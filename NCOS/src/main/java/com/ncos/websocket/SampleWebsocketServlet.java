package com.ncos.websocket;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.arnx.jsonic.JSON;

import org.apache.catalina.websocket.MessageInbound;
import org.apache.catalina.websocket.StreamInbound;
import org.apache.catalina.websocket.WebSocketServlet;
import org.apache.catalina.websocket.WsOutbound;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.google.gson.Gson;
import com.ncos.user.entity.User;
import com.ncos.user.service.UserService;

@WebServlet(urlPatterns = { "/sample/" })
//@Component("myServlet")
public class SampleWebsocketServlet extends WebSocketServlet{

	@Autowired
	UserService userService;
	
	private Log log = LogFactory.getLog(getClass());

	/**
	 * SerialVersionUID.
	 */

	// 사용자 이름
	private static final String GUEST_PREFIX = "Guest_%02d";
	// 사용자 ID 생성 (1씩 증가)
	private final AtomicInteger ids = new AtomicInteger(0);
	// 사용자 연결 유지용
	private final Set<SampleMessageInbound> connections = new CopyOnWriteArraySet<SampleMessageInbound>();

	//json변환 객체
	private Gson gson = new Gson();
	/**
	 * 연결 생성시 방법
	 */
	@Override
	protected StreamInbound createWebSocketInbound(String arg0,
			HttpServletRequest arg1) {
		log.info(arg0);
		return new SampleMessageInbound(ids.incrementAndGet());
	}

	/**
	 * 통신을 위한 클래스
	 */
	private class SampleMessageInbound extends MessageInbound {

		// 이름
		private String name;

		public SampleMessageInbound(int id) {
			name = String.format(GUEST_PREFIX, id);
		}

		@Override
		protected void onBinaryMessage(ByteBuffer arg0) throws IOException {
		}

		/**
		 * 문자메시지 수신시
		 */
		@Override
		protected void onTextMessage(CharBuffer message) throws IOException {
			// Never trust the client
			// json을 객체에 매핑
//			Message m = JSON.decode(message.toString(), Message.class);
			System.out.println("#### message.toString : "+message.toString() + "#############");
			Message m = gson.fromJson(message.toString(), Message.class);
			
			String filteredMessage = String.format("%s: %s", name, m.data);
			
			log.info(filteredMessage);
			String[] loc = m.data.split("@");
			if(loc.length>1){
				broadcast(filteredMessage,loc[1]);
			}else{
				broadcast(filteredMessage,"x0y0");
			}
		}

		/**
		 * 연결 시작
		 */
		protected void onOpen(WsOutbound outbound) {
			connections.add(this);
			String message = String.format("%s %s", name, "has joined.");
			log.info(message);
			broadcast(message,"x0y0");
		}

		/**
		 * 연결 종료
		 */
		@Override
		protected void onClose(int status) {
			connections.remove(this);
			String message = String.format("%s %s", name, "has disconnected.");
			log.info(message);
			broadcast(message,"x0y0");
		}

		private void broadcast(String message, String location) {
			List<User> list = (List<User>) userService.getList();
			System.out.println("++++++++ list.size : "+list.size()+" ++++++++++++");
			log.info(message);
			for (SampleMessageInbound connection : connections) {
				try {
//					CharBuffer buffer = CharBuffer.wrap(JSON
//							.encode(new Message(message)));
					CharBuffer buffer = CharBuffer.wrap(gson.toJson(new Message(message,location)));
					
					
//					log.info(JSON.encode(new Message(message)));
					connection.getWsOutbound().writeTextMessage(buffer);
				} catch (IOException e) {
					log.error(e, e);
				}
			}
		}
	}

	private class Message {
		public Message() {
		}

		public Message(String message,String location) {
			this.type = "message";
			this.data = message;
			this.location = location;
		}

		public String data;
		public String type;
		public String location;
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException{
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
		super.init(config);
	}
}