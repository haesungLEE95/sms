<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<html>
<head>
<meta charset="UTF-8">
<title>관리자</title>
</head>
<body>
	<div class="container" align="center">
		<h2 class="text-primary">관리자 페이지</h2>
	</div>
	<c:redirect url="smsMemList.do"/>
</body>
<%-- <c:choose>
	<c:when test="${admin_id == 'admin'}">	
	<c:redirect url="memList.do"/>
	</c:when>	
	<c:otherwise>
		<c:when test="${admin_id == null}">
		<c:redirect url="main.do"/>
		</c:when>
	</c:otherwise>
</c:choose> --%>

</html>




