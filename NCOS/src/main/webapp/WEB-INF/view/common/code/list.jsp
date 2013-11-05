<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/taglibs.jsp"%>

<layout:extends name="layout-admin">
	<layout:put block="header" type="REPLACE">
		<title>코드관리</title>
		<script>
			$().ready(function(){
			});
		
			//신규
			function create(){
				$("#codeForm").attr("action","<c:url value='/common/code/createForm'/>");
				$("#codeForm").submit();
			}
			//수정
			function edit(masterCode,detailCode){
				$("#masterCode").val(masterCode);
				$("#detailCode").val(detailCode);
				$("#codeForm").attr("action","<c:url value='/common/code/editForm'/>");
				$("#codeForm").submit();
			}
			//페이지 이동
			function linkPage(pageNo){
				$("#currentPageNo").val(pageNo);
				$("#codeForm").attr("action","<c:url value='/common/code/list'/>");
				$("#codeForm").submit();
			}
		</script>		
	</layout:put>
    <layout:put block="contents" type="REPLACE">
		<form name="codeForm" id="codeForm" action="<c:url value='/common/code/editForm'/>" method="post">
			<input type="hidden" name="masterCode" id="masterCode" />
			<input type="hidden" name="detailCode" id="detailCode" />
			<input type="hidden" name="currentPageNo" id="currentPageNo" value="${param.currentPageNo}"/>
		</form>
		
			<table>
				<tr>
					<td>마스터코드</td>
					<td>상세코드</td>
					<td>코드명</td>
				</tr>
				<c:forEach items="${items}" var="item">
					<tr>
						<td>${item.masterCode}</td>
						<td>${item.detailCode}</td>
						<td><a href="javascript:;" onclick="edit('${item.masterCode}','${item.detailCode}');">${item.codeName}</a></td>
					</tr>
				</c:forEach>
			</table>
			<ui:pagination  paginationInfo="${paginationInfo}" jsFunction="linkPage" />
			<input type="button" value="신규" onclick="create();"/>
	</layout:put>
</layout:extends>
