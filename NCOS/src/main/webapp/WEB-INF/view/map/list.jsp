<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script type="text/javascript" src="<c:url value='/contents/script/jquery/jquery-1.10.2.min.js'/>"></script>
	<link rel="stylesheet" href="<c:url value='/contents/css/table.css'/>">
	<script>
		$().ready(function(){
		});
	
		function create(){
			$("#mapForm").submit();
		}
	</script>
</head>
<body>
	<form name="mapForm" id="mapForm" action='<c:url value="/map/createForm"/>' method="post">
		<table class="default_table" border="1">
			<tr>
				<td>썸네일</td>
				<td>맵이름</td>
				<td>가로</td>
				<td>세로</td>
			</tr>
			<c:forEach items="${mapInfoItems}" var="item">
				<tr>
					<td><img src="<c:url value='/static/${item.filePath}_th.bmp' />"/></td>
					<td><a href="<c:url value='/map/createField?mapid=${item.mapid}' />">${item.mapName}</a></td>
					<td>${item.width}</td>
					<td>${item.height}</td>
				</tr>
			</c:forEach>
		</table>
	
	<input type="button" value="신규" onclick="create();"/>
	</form>
</body>
</html>