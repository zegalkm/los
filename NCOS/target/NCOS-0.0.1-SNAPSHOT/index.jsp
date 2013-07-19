<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="contents/script/jquery/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="contents/script/jquery/jquery.json-2.3.min.js"></script>
	<script type="text/javascript" src="contents/script/jquery/jquery.websocket-0.0.1.js"></script>
	<title>WebSocket Sample</title>
</head>
<script type="text/javascript">
$(document).ready(function(){
        // WebSocket통신모듈생성
	var ws = $.websocket("ws://localhost:8080/Taengoo/sample/", {
                // 메시지 이벤트
		events: {
                        // 메시지 수신시..
			message: function(e) {$("#content").append(e.data + "<br>")}
		}
	});
	$("#message").change(function(){
		ws.send("message", this.value);
		this.value = "";
	});	
});

</script>
<body>
  <section id="content">
  </section>
  <input type="text" value="" id="message">
</body>
</html>