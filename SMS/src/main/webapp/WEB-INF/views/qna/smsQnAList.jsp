<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container" align="center">
		<h2>거래문의</h2>
		<table class="table table-striped">
			<tr>
				<td>문의글제목</td>
				<td>문의날짜</td>
				<td>문의현황</td>
			</tr>
	<%-- 		<c:if test="${empty }">
				<tr>
					<td colspan="4">데이터가 없습니다</td>
				</tr>
			</c:if>
			<c:if test="${not empty }">

			</c:if> --%>
		</table>
	</div>
</body>
</html>