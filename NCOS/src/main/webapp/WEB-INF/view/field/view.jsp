<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/contents/script/jquery/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#td5").bind('mousemove',function(e){
		var obj = $(this);
		var offset = obj.offset();
		var x = e.pageX;
		var y = e.pageY;
		$("#profile").css({"left" : x , "top" : y}).show();
	});
	$("#td5").bind('mouseout',function(e){
		$("#profile").hide();
	});
});
function showProfile(object,event){
	var obj = $(object);
	var offset = obj.offset();
	var x = event.pageX;
	var y = event.pageY;
	$("#profile").css({"left" : x , "top" : y}).show();
}
function right(){
	alert("right");
}
</script>
</head>
<body>
<table style="border: 1px solid red; margin-top: 100px;">
	<tr>
		<td id="td1">sdasdasdasdas</td>
		<td id="td2">sdasdasdasdas</td>
		<td id="td3">sdasdasdasdas</td>
		<td id="td4" oncontextmenu="javascript:right();">td4</td>
		<td id="td5">td5<br/>asdasdasd<br/>rasdasdasdasd<br/></td>
	</tr>
</table>
<input type="button" value="클릭" onclick="javascript:view();" />
<div id="profile" style="width: 150px; height: 100px; background-color:gray; ;position:absolute;display:none;z-index:5;">
프로필이다<br/>
asdasddddddddasdasdasdasdasdsadasdasddasasasd
</div>
</body>
</html>