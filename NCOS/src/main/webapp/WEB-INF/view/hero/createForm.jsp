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
	<form name="heroForm" id="heroForm" action='<c:url value="/hero/saveHero"/>' method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>장수명</td>
				<td><input type="text" name="heroName" /></td>
			</tr>
			<tr>
				<td>타입</td>
				<td><input type="text" name="type" /></td>
			</tr>
			<tr>
				<td>가격</td>
				<td><input type="text" name="price" /></td>
			</tr>
			<tr>
				<td>이동범위</td>
				<td><input type="text" name="movArea" /></td>
			</tr>
			<tr>
				<td>무력</td>
				<td><input type="text" name="force" /></td>
			</tr>
			<tr>
				<td>지력</td>
				<td><input type="text" name="intellect" /></td>
			</tr>
			<tr>
				<td>통솔</td>
				<td><input type="text" name="leadership" /></td>
			</tr>
			<tr>
				<td>매력</td>
				<td><input type="text" name="charm" /></td>
			</tr>
			<tr>
				<td>조형 - ATK</td>
				<td><input type="text" name="char_file1" /></td>
			</tr>
			<tr>
				<td>조형 - MOV</td>
				<td><input type="text" name="char_file2" /></td>
			</tr>
			<tr>
				<td>조형 - SPC</td>
				<td><input type="text" name="char_file3" /></td>
			</tr>
			<tr>
				<td>배경선택</td>
				<td><input type="text" name="char_file3" /></td>
			</tr>
		</table>
		<input type="button" value="등록" onclick="javascript:save();"/>
	</form>	
</body>
</html>