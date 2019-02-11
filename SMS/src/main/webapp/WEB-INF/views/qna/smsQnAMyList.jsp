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
				<!-- <td>번호</td> -->
				<td>거래문의 </td>
				<td>작성자</td>
				<td>문의날짜</td>
			</tr>
				<c:forEach var="smssqa" items="${list}">
<%-- 					<c:if test="${smssqa.ssb_no==mem_no}"> --%>  
						<c:if test="${empty list}">
							<tr>
								<td colspan="3" align="center">데이터가 없습니다</td>
							</tr>
						</c:if>
						<c:if test="${not empty list}">
							<tr>
								<%-- <td>${smssqa.qna_no}</td> --%>
								<td><a href="smsQnaView.do?num=${smssqa.qna_no}&
										pageNum=${pb.currentPage}">${smssqa.sms_qna}</a>
								</td>
								<td>${smssqa.nickname}</td>
								<td>${smssqa.qna_date}</td>
							</tr>
						</c:if>
					<%-- </c:if> --%>
				</c:forEach>
		</table>
 		<div align="center">
			<ul class="pagination">
				<c:if test="${pb.startPage > pb.pagePerBlock}">
					<li><a href="smsQnAList.do?pageNum=1"><span
							class="glyphicon glyphicon-backward"></span></a></li>
					<li><a href="smsQnAList.do?pageNum=${pb.startPage - 1}"
						class="glyphicon glyphicon-triangle-left"></a></li>
				</c:if>
				<c:forEach var="i" begin="${pb.startPage}" end="${pb.endPage}">
					<c:if test="${i==pb.currentPage}">
						<li class="active"><a href="smsQnAList.do?pageNum=${i}">
								${i}</a></li>
					</c:if>
					<c:if test="${i!=pb.currentPage}">
						<li><a href="smsQnAList.do?pageNum=${i}">${i}</a></li>
					</c:if>
				</c:forEach>
				<c:if test="${pb.endPage < pb.totalPage}">
					<li><a href="smsQnAList.do?pageNum=${pb.endPage + 1}"
						class="glyphicon glyphicon-triangle-right"></a></li>
					<li><a href="smsQnAList.do?pageNum=${pb.totalPage}"><span
							class="glyphicon glyphicon-forward"></span></a></li>
				</c:if>
			</ul>
		</div> 
	</div>
</body>
</html>