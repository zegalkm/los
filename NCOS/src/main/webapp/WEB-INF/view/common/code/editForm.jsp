<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>코드수정</title>
	<script type="text/javascript" src="<c:url value='/contents/script/jquery/jquery-1.10.2.min.js'/>"></script>
	<script>
		$().ready(function(){
		});
	
		function save(){
			$("#masterCode").attr("disabled",false);
			$('#codeForm').submit();
		}
	</script>
</head>
<body>
	<form name="codeForm" id="codeForm" action='<c:url value="/common/code/updateCode"/>' method="post">
		<table>
			<tr>
				<td>마스터코드</td>
				<td>
					<input type="text" name="masterCode" id="masterCode" value="${code.masterCode}" disabled="disabled"/>
				</td>
			</tr>
			<tr>
				<td>상세코드</td>
				<td>
					<input type="text" name="detailCode" id="detailCode" value="${code.detailCode}"/>
				</td>
			</tr>
			<tr>
				<td>코드명</td>
				<td>
					<input type="text" name="codeName" id="codeName" value="${code.codeName}"/>
				</td>
			</tr>
			<tr>
				<td>코드설명</td>
				<td>
					<input type="text" name="codeDesc" id="codeDesc" value="${code.codeDesc}"/>
				</td>
			</tr>
			<tr>
				<td>순서</td>
				<td>
					<input type="text" name="sortNum" id="sortNum" value="${code.sortNum}"/>
				</td>
			</tr>
		</table>
		<input type="button" value="저장" onclick="javascript:save();"/>
	</form>	
</body>
</html>