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
			$(".default_table td").mouseover(function(){
				$(this).addClass("td_bgcolor");
			}).mouseout(function(){
				$(this).removeClass("td_bgcolor");
			});
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
		<c:set var="colCount" value="${mapInfo.width/48}"/>
		<c:set var="rowCount" value="${mapInfo.height/48}"/>
		<table class="default_table" border="1" style="width: ${mapInfo.width}px; height:${mapInfo.height}px; background:url(<c:url value='/static/${mapInfo.filePath}.bmp' />);" >
			<c:forEach begin="1" end="${rowCount}">
				<tr>
					<c:forEach begin="1" end="${colCount}">
						<td style="width: 48px; height: 48px;"></td>
					</c:forEach>
				</tr>
			</c:forEach>
		</table>
	</form>	
</body>
</html>