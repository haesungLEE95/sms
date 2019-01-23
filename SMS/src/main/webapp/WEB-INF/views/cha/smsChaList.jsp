<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<!DOCTYPE html><html><head><meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container" align="center">
		<h4 class="text-primary">신고게시판</h4>
		<table class="table table-hover">
			<tr>
				<td>번호</td>
				<td>제목</td>
				<td>작성자</td>
				<td>날짜</td>
			</tr>
			<%-- <c:forEach var="dept" items="${list }">
				<tr>
					<td>${dept.deptno}</td>
					<td><a class="btn btn-info btn-sm"
						href="empList.do?deptno=${dept.deptno}">${dept.dname}</a></td>
					<td>${dept.loc }</td>
					<td><a class="btn btn-warning btn-sm"
						href="deptUpdateForm.do?deptno=${dept.deptno}">수정</a></td>
					<td><a class="btn btn-danger btn-sm"
						href="deptDelete.do?deptno=${dept.deptno}">삭제</a>
			</c:forEach> --%>
		</table>
		<!-- <a class="btn btn-default" href="deptInsertForm.do">부서입력</a> --> 
	</div>
</body>
</html>