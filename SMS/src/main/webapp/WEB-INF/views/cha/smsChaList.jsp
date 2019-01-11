<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<!DOCTYPE html><html><head><meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container" align="center">
		<h2 class="text-primary">신고</h2>
		<c:set var="num" value="${no}"></c:set>
		<table class="table table-hover">
			<tr>
				<td>번호</td>
				<td>제목</td>
				<td>작성자</td>
				<td>조회수</td>
				<td>날짜</td>
			</tr>
			 <c:forEach var="smscha" items="${list }">
				<tr>
					<td>${smscha.cha_no}</td>
					<td><a class="btn btn-info btn-sm" href="smsView.do">${smscha.cha_title}</a></td>
					<td>${smscha.mem_no }</td>
					<td>${smscha.cha_count}</td>
					<td>${smscha.cha_date}</td>
				</tr>
			</c:forEach> 
				<c:if test="${empty list}">
				<tr>
					<td colspan="5" align="center">데이터가 없습니다</td>
				</tr>
				</c:if>
		</table>
		<div>
			<a class="btn btn-info" href="smsInsertForm.do">신고글쓰기</a>
		</div>	
	</div>
</body>
</html>