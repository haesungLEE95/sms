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
		<h2 class="text-primary">불편신고</h2>

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
					<td><a href="smsView.do?num=${smscha.cha_no}">${smscha.cha_title}</a>
					</td>
					<td>${memNick}</td>
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

		<div align="center ">
			<ul class="pagination">
				<c:if test="${pb.startPage > pb.pagePerBlock}">
					<li><a href="smsChaList.do?pageNum=1"> <span
							class="glyphicon glyphicon-backward"></span></a></li>
					<li><a href="smsChaList.do?pageNum/${pb.startPage - 1}"
						class="glyphicon glyphicon-triangle-left"></a></li>
				</c:if>
				<c:forEach var="i" begin="${pb.startPage}" end="${pb.endPage}">
					<c:if test="${i==pb.currentPage}">
						<li class="active"><a href="smsChaList.do?pageNum=${i}">${i }</a>
						</li>
					</c:if>
					<c:if test="${i!=pb.currentPage }">
						<li><a href="smsChaList.do?pageNum=${i}">${i }</a></li>
					</c:if>
				</c:forEach>
				<c:if test="${pb.endPage < pb.totalPage}">
					<li><a href="smsChaList.do?pageNum=${pb.endPage + 1}"
						class="glyphicon glyphicon-triangle-right"></a></li>
					<li><a href="smsChaList.do?pageNum=${pb.totalPage}"> <span
							class="glyphicon glyphicon-forward"></span></a></li>
				</c:if>
			</ul>
		</div>

		<div>
			<a class="btn btn-info" href="smsInsertForm.do">신고글쓰기</a>
		</div>
	</div>
</body>
</html>