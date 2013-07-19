<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script type="text/javascript" src="<c:url value='/contents/script/jquery/jquery-1.10.2.min.js'/>"></script>
	<script>
		$().ready(function(){
		});
	
		function save(){
			$('#heroForm').submit();
		}
	</script>
</head>
<body>
${hero.heroName}
	<form name="heroForm" id="heroForm" action='<c:url value="/hero/saveHero"/>' method="post" >
		<table>
			<tr>
				<td>장수명</td>
				<td><input type="text" name="heroid" /></td>
			</tr>
		</table>
		<input type="button" value="등록" onclick="javascript:save();"/>
	</form>	
</body>
</html>