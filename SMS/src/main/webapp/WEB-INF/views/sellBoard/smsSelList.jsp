<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container" align="center">

<!-- 		<div class="col-sm-6 col-md-3">
			<div class="thumbnail"><a href="#" class="thumbnail"><img src="../../../images/DSC_6305.jpg" alt="..."></a>
				<div class="caption"><h3>제목과</h3><p>내용도 넣을 수 있다.</p>
					<p><a href="#" class="btn btn-primary" role="button">Button</a>
						<a href="#" class="btn btn-default" role="button">Button</a></p>
				</div>
			</div>
		</div> -->
		<h2 class="text-primary">판매 게시판 목록</h2>
			<c:set var="row" value="0"></c:set>
			<c:if test="${empty list}">
				데이터가 없습니다
			</c:if>
			<c:if test="${not empty list}">
				<c:forEach var="board" items="${list}">
					<c:set var="num" value="${num + 1}"></c:set>				
					<div class="col-sm-6 col-md-3">
						<div class="thumbnail">
							<c:if test="${board.sb_img=='' || board.sb_img==null }">
							<a href="smsSellBoardView.do?num=${board.sb_no }&pageNum=${pb.currentPage}" class="thumbnail"><img src="images/DSC_6305.jpg" alt="..."></a>
							</c:if>
							<c:if test="${board.sb_img!='' && board.sb_img!=null}">
							${board.sb_img}aaa
							</c:if>
<%-- 						이미지 Path 지정
							<c:if test="${board.sb_img!='' }">
							<a href="#" class="thumbnail"><img src="../../../images/DSC_6305.jpg" alt="..."></a>
							</c:if> --%>
							<div class="caption">
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
								<p>${board.sb_title }</p>
								<h3><p>${board.sb_price }~</p></h3>
								<p><a href="smsSellBoardView.do?num=${board.sb_no }&pageNum=${pb.currentPage}" class="btn btn-primary" role="button">구매하기</a>
									<a href="#" class="btn btn-default" role="button">구매하기</a></p>
							</div>
						</div>
					</div>
					<c:if test="${num%5==0 }">
						<hr>
					</c:if>
				</c:forEach>
			</c:if>
		<br>
		<div align="center">
			<ul class="pagination">
				<c:if test="${pb.startPage > pb.pagePerBlock}">
					<li><a
						href="smsSellBoardList.do?pageNum=1"><span
							class="glyphicon glyphicon-backward"></span></a></li>
					<li><a
						href="smsSellBoardList.do?pageNum=${pb.startPage - 1}"
						class="glyphicon glyphicon-triangle-left"></a></li>
				</c:if>
				<c:forEach var="i" begin="${pb.startPage}" end="${pb.endPage}">
					<c:if test="${i==pb.currentPage}">
						<li class="active"><a
							href="smsSellBoardList.do?pageNum=${i}">
								${i}</a></li>
					</c:if>
					<c:if test="${i!=pb.currentPage}">
						<li><a
							href="smsSellBoardList.do?pageNum=${i}">${i}</a></li>
					</c:if>
				</c:forEach>
				<c:if test="${pb.endPage < pb.totalPage}">
					<li><a
						href="smsSellBoardList.do?pageNum=${pb.endPage + 1}"
						class="glyphicon glyphicon-triangle-right"></a></li>
					<li><a
						href="smsSellBoardList.do?pageNum=${pb.totalPage}"><span
							class="glyphicon glyphicon-forward"></span></a></li>
				</c:if>
			</ul>
		</div>
		<a class="btn btn-info" href="smsSellBoardInsertForm.do?pageNum=1">게시글 입력</a>
	</div>
</body>
</html>