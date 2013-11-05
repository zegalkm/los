<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
    <head>
  		<meta charset="UTF-8">
	 	<script type="text/javascript" src="<c:url value='/contents/script/jquery/jquery-1.10.2.min.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/contents/bootstrap/js/bootstrap.min.js'/>" ></script>
		<link href="/contents/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen"> 		
  		<layout:block name="header">
       		<title>NCOS jsp template</title>
    	</layout:block>    	
    </head>

	<body>
		
		<div>
			<layout:block name="top">
				<div class="btn-group">
				  <a class="btn dropdown-toggle" data-toggle="dropdown">
				    메뉴
				    <span class="caret"></span>
				  </a>
				  <ul class="dropdown-menu">
				    <!-- dropdown menu links -->
				    <li><a href="/common/code/list">코드관리</a></li>
				    <li><a href="/map/list">맵관리</a></li>
				    <li><a href="/hero/list">영웅관리</a></li>
				    <li><a href="#">사용자관리</a></li>
				  </ul>
				</div>				
			</layout:block>		
		</div>
		
		<div>
		    <layout:block name="contents">
		        <h2>Contents will be placed under this h2</h2>
		    </layout:block>
		</div>
		
		<div class="footer">
		</div>
	
	</body>
</html>