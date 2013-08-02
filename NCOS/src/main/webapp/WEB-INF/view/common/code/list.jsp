<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>코드관리</title>
	<script type="text/javascript" src="<c:url value='/contents/script/jquery/jquery-1.10.2.min.js'/>"></script>
	<script>
		$().ready(function(){
		});
	
		function create(){
			$("#codeForm").submit();
		}
	</script>
</head>
<body>
	<form name="codeForm" id="codeForm" action='<c:url value="/common/code/createForm"/>' method="post">
	<input type="button" value="신규" onclick="create();"/>
	</form>
</body>
</html>