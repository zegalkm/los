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
	<form name="mapInfoForm" id="mapInfoForm" action='<c:url value="/map/saveMapInfo"/>' method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>맵이름</td>
				<td><input type="text" name="mapName" /></td>
			</tr>
			<tr>
				<td>맵이미지</td>
				<td><input type="file" name="map_file" /></td>
			</tr>
		</table>
		<input type="button" value="등록" onclick="javascript:save();"/>
	</form>	
</body>
</html>