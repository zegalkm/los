<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>코드등록</title>
	<script type="text/javascript" src="<c:url value='/contents/script/jquery/jquery-1.10.2.min.js'/>"></script>
	<script>
		$().ready(function(){
		});
	
		function save(){
			$('#codeForm').submit();
		}
	</script>
	<style type="text/css">
	.op1{background-color: red;}
	</style>
</head>
<body>
	<form name="codeForm" id="codeForm" action='<c:url value="/common/code/saveCode"/>' method="post">
		<table>
			<tr>
				<td>마스터코드</td>
				<td>
					<select id="selectMasterCode">
						<c:forEach items="${masterCodeList}" var="masterCode">
							<option value="${masterCode}">${masterCode}</option>
						</c:forEach>
					</select>
					<input type="text" name="masterCode" id="masterCode"/>
				</td>
			</tr>
			<tr>
				<td>상세코드</td>
				<td>
					<input type="text" name="detailCode" id="detailCode"/>
				</td>
			</tr>
			<tr>
				<td>코드명</td>
				<td>
					<input type="text" name="codeName" id="codeName"/>
				</td>
			</tr>
			<tr>
				<td>코드설명</td>
				<td>
					<input type="text" name="codeDesc" id="codeDesc"/>
				</td>
			</tr>
			<tr>
				<td>순서</td>
				<td>
					<input type="text" name="sortNum" id="sortNum"/>
				</td>
			</tr>
		</table>
		<input type="button" value="등록" onclick="javascript:save();"/>
	</form>	
</body>
</html>