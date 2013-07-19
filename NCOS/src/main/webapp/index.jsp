<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/taglibs.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset=UTF-8>
        <title>Tomcat WebSocket Chat</title>
        
        <script type="text/javascript" src="<c:url value='/contents/script/jquery/jquery-1.7.2.min.js'/>"></script>
        <script type="text/javascript" src="<c:url value='/contents/script/jquery/jquery.json-2.3.min.js'/>"></script>
        <script type="text/javascript" src="<c:url value='/contents/script/engine/character.js'/>"></script>
        <link type="text/css" rel="stylesheet" href="<c:url value="/contents/css/character.css"/>" />
        
        <script>
        var ws;
        var loginUser = null;
        $().ready(function(){
        	
            ws = new WebSocket("ws://localhost:8080/NCOS/chat/");
            ws.onopen = function(){
            	//var thing = {flag : 'login' , userId : id, userImg : img, gpsX : '1', gpsY : '0', movingDistance : '3'};
            	//var encoded = $.toJSON(thing);
            	//ws.send(encoded);
            };
            ws.onmessage = function(message){
            	var jsondata = $.evalJSON(message.data);
            	if(jsondata.flag==='login'){
            		if(loginUser===null){
            			loginUser = jsondata.userId;
            		}
	            	var character = new Character(jsondata);
	            	character.playerClick();
	            	character.playerMove();
            	}
            	
                //document.getElementById("chatlog").textContent += message.data + "\n";
            };
        });
            function postToServer(){
            	var loginInfo = $("#msg").val();
            	var data = loginInfo.split("@");
            	var thing = {flag:'login',userId:data[0],userImg:data[1],gpsX : '1', gpsY : '0', movingDistance : '3'};
            	var encoded = $.toJSON(thing);
            	ws.send(encoded);
            	$("#msg").remove();
            }
            function closeConnect(){
                ws.close();
            }
        </script>
    </head>
    <body>
    <div id="map">
    <table id="field_table" class="field_table" style="border: solid 1px red;">
    <%
	for(int i=0; i<20; i++){
    %>
  	<tr>
    <%
    	for(int j=0; j<20; j++){
    %>
    	<td id="<%=j%>_<%=i%>" style="width:64px; height:64px; border: solid 1px red;"></td>
    <% 		
    	}
    %>
    </tr>
    <%
	}
    %>
  	</table>
  	</div>
  	<div style="position: relative;">
        <input id="msg" type="text" />
        <button type="submit" id="sendButton" onClick="postToServer()">Send!</button>
        <button type="submit" id="sendButton" onClick="closeConnect()">End</button>
    </div>    
    </body>
</html>