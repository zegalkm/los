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
	
		//저장
		function save(){
			$("#masterCode").attr("disabled",false);
			$("#detailCode").attr("disabled",false);
			$('#codeForm').submit();
		}
		//삭제
		function remove(){
			$("#masterCode").attr("disabled",false);
			$("#detailCode").attr("disabled",false);
			$("#codeForm").attr("action","<c:url value='/common/code/deleteCode'/>");
			$('#codeForm').submit();
		}
		//취소
		function cancel(){
			$("#currentPageNo").val(pageNo);
			$("#masterCode").attr("disabled",false);
			$("#detailCode").attr("disabled",false);
			$("#codeForm").attr("action","<c:url value='/common/code/list'/>");
			$('#codeForm').submit();
		}
	</script>
</head>
<body>
	<form name="codeForm" id="codeForm" action='<c:url value="/common/code/updateCode"/>' method="post">
		<input type="hidden" name="currentPageNo" id="currentPageNo" />
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
					<input type="text" name="detailCode" id="detailCode" value="${code.detailCode}" disabled="disabled"/>
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
		<input type="button" value="삭제" onclick="javascript:remove();"/>
		<input type="button" value="취소" onclick="javascript:cancel();"/>
	</form>	
</body>
</html>