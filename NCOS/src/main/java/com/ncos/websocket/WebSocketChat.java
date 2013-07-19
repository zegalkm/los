package com.ncos.websocket;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.websocket.MessageInbound;
import org.apache.catalina.websocket.StreamInbound;
import org.apache.catalina.websocket.WebSocketServlet;
import org.apache.catalina.websocket.WsOutbound;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.google.gson.Gson;

@WebServlet(urlPatterns = { "/chat/" })
public class WebSocketChat extends WebSocketServlet{
    private static final long serialVersionUID = 1L;
    private static ArrayList<MyMessageInbound> mmiList = new ArrayList<MyMessageInbound>();
 
	//json변환 객체
	private Gson gson = new Gson();
    
	@Override
	protected StreamInbound createWebSocketInbound(String arg0,HttpServletRequest request) {
		return new MyMessageInbound();
	}
    private class MyMessageInbound extends MessageInbound{
        WsOutbound myoutbound;
 
		/**
		 * 연결시
		 */
        @Override
        public void onOpen(WsOutbound outbound){
            try {
                System.out.println("Open Client.");
                this.myoutbound = outbound;
                mmiList.add(this);
                outbound.writeTextMessage(CharBuffer.wrap("Hello!"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
 
		/**
		 * 연결 종료시
		 */
        @Override
        public void onClose(int status){
            System.out.println("Close Client.");
            mmiList.remove(this);
        }
 
		/**
		 * 문자메시지 수신시
		 */
        @Override
        public void onTextMessage(CharBuffer cb) throws IOException{
            System.out.println("Accept Message : "+ cb);
            Message m = gson.fromJson(cb.toString(), Message.class);
            System.out.println("FLAG : "+m.flag);
            System.out.println("ID : "+m.userId);
            System.out.println("IMG : "+m.userImg);
            System.out.println("GPS : "+m.gps);
            if(StringUtils.equals("login", m.flag)){//최초접속
            	//비즈니스 로직 호출.
            	
            }else{
            	
            }
            for(MyMessageInbound mmib: mmiList){
                CharBuffer buffer = CharBuffer.wrap(cb);
                mmib.myoutbound.writeTextMessage(buffer);
                mmib.myoutbound.flush();
            }
        }
 
        @Override
        public void onBinaryMessage(ByteBuffer bb) throws IOException{
        }
    }
    
    
    private class Message{
    	public String flag;
    	public String userId;
    	public String userImg;
    	public String gps;
    }
    
	@Override
	public void init(ServletConfig config) throws ServletException{
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
		super.init(config);
	}

}
