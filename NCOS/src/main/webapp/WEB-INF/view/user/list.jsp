<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/contents/script/jquery/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
$().ready(function(){
	alert("It's jquery!");
});
</script>
</head>
<body>
<c:forEach items="${userList}" var="user">
	${user.name},
</c:forEach>
</body>
</html>