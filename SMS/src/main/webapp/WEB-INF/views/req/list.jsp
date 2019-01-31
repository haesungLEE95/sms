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
		<h2 class="text-primary">의뢰 게시판 목록</h2>
		<table class="table table-striped">
			<tr>
				<td>번호</td>
				<td>카테고리</td>
				<td>제목</td>
				<td>작성자</td>
				<td>조회수</td>
				<td>작성일</td>
				<td>의뢰현황</td>
			</tr>
			<c:if test="${empty list}">
				<tr>
					<td colspan="7">데이터가 없습니다</td>
				</tr>
			</c:if>
			<c:if test="${not empty list}">
				<c:forEach var="board" items="${list}">
					<tr>
						<td>${board.rq_no }</td>
						<td>
							<c:forEach var="mcate" items="${mcateList }">
								<c:if test="${mcate.mcate_no==board.mcate_no }">
									 <span class="label label-info">${mcate.mcate_name }</span>
								</c:if>
							</c:forEach>
							<c:forEach var="scate" items="${scateList }">
								<c:if test="${scate.scate_no==board.scate_no }">
									<span class="label label-info">${scate.scate_name }</span>
								</c:if>
							</c:forEach>
						</td>
						<td><a href="view.do?num=${board.rq_no }&pageNum=${pb.currentPage}">${board.rq_title}</a></td>
						<td>${board.mem_no }</td>
						<td>${board.rq_count }</td>
						<td>${board.rq_date }</td>
						<td>
							<c:if test="${board.rq_cond%2==0}">의뢰중</c:if>
							<c:if test="${board.rq_cond%2!=0}">완료</c:if>
						</td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
		<div align="center">
			<ul class="pagination">
				<c:if test="${pb.startPage > pb.pagePerBlock}">
					<li><a
						href="list.do?pageNum=1"><span
							class="glyphicon glyphicon-backward"></span></a></li>
					<li><a
						href="list.do?pageNum=${pb.startPage - 1}"
						class="glyphicon glyphicon-triangle-left"></a></li>
				</c:if>
				<c:forEach var="i" begin="${pb.startPage}" end="${pb.endPage}">
					<c:if test="${i==pb.currentPage}">
						<li class="active"><a
							href="list.do?pageNum=${i}">
								${i}</a></li>
					</c:if>
					<c:if test="${i!=pb.currentPage}">
						<li><a
							href="list.do?pageNum=${i}">${i}</a></li>
					</c:if>
				</c:forEach>
				<c:if test="${pb.endPage < pb.totalPage}">
					<li><a
						href="list.do?pageNum=${pb.endPage + 1}"
						class="glyphicon glyphicon-triangle-right"></a></li>
					<li><a
						href="list.do?pageNum=${pb.totalPage}"><span
							class="glyphicon glyphicon-forward"></span></a></li>
				</c:if>
			</ul>
		</div>
		<a class="btn btn-info" href="insertForm.do?pageNum=1">게시글 입력</a>
	</div>
</body>
</html>