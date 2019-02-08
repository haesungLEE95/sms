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
		<h2 class="text-primary">나의 구매 목록</h2>
		<table class="table table-striped">
			<tr>
				<td>구매글제목</td>
				<td>가격</td>
				<td>구매일자</td>
				<td>거래현황</td>
			</tr>
			<c:if test="${empty list}">
				<tr>
					<td colspan="4">데이터가 없습니다</td>
				</tr>
			</c:if>
			<c:if test="${not empty list}">
				<c:forEach var="board" items="${list}">
					<tr>
						<td><img src="images/DSC_6305.jpg" alt="..." height="100px" width="100px">${board.sb_title }</td>
						<td>${board.qst_price }</td>
						<td>${board.qst_dar }</td>
						<td>
							<c:if test="${board.qst_comp%2==0}">거래중</c:if>
							<c:if test="${board.qst_comp%2!=0}">완료</c:if>
			<td>
				<c:if test="${board.qst_comp%2==0}">
				
					<a class="btn btn-primary btn-lg" href="smsBuyCondition.do?num=${smsReq.rq_no}&pageNum=${pageNum}">거래 중</a>
				</c:if>
				<c:if test="${board.qst_comp%2!=0}">
					<a class="btn btn-success btn-lg" href="smsBuyCondition.do?num=${smsReq.rq_no}&pageNum=${pageNum}">완료</a>
				</c:if>
			</td>
						</td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
	</div>
</body>
</html>