<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<!DOCTYPE html><html><head><meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container" align="center">
		<h2 class="text-primary">신고게시판</h2>
		<table class="table table-hover">
			<tr>
				<td>번호</td>
				<td>제목</td>
				<td>조회수</td>
				<td>날짜</td>
			</tr>
			 <c:forEach var="smscha" items="${list }">
				<tr>
					<td>${smscha.cha_no}</td>
					<td><a class="btn btn-info btn-sm">${smscha.cha_title}</a></td>
					<td>${smscha.cha_count}</td>
					<td>${smscha.cha_date}</td>
			</c:forEach> 
		</table>
	</div>
</body>
</html>