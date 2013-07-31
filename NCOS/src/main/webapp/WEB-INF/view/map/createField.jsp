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
			$('#mapInfoForm').submit();
		}
	</script>
</head>
<body>
	<form name="mapFieldForm" id="mapFieldForm" action='<c:url value="/map/saveMapInfo"/>' method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>맵이름 : ${mapInfo.mapName}</td>
			</tr>
			<tr>
				<td>이미지 : ${mapInfo.filePath}</td>
			</tr>
		</table>
		<table style="width: ${mapInfo.width}px; height:${mapInfo.height}px;">
			<tr>
				<td><img src="<c:url value='/static/map/abc.bmp' />"/></td>
			</tr>
		</table>
	</form>	
</body>
</html>