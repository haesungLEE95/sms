<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script type="text/javascript">
		function button_comp_event(){
			if (confirm("거래를 완료하시겠습니까??") == true){    //확인
			    location.href="smsBuyCondition.do?sb_no=${smssel.sb_no}&price=${smssel.sb_price}&pageNum=${pageNum}";
			}else{   //취소
			    return;
			}
		}
	</script>
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
						<td>${board.qst_price }원</td>
						<td>${board.qst_dar }</td>
						<td>
							<c:if test="${board.qst_comp%2==0}">
								<!-- <input onclick="button_comp_event();" type="button" value="완료하기" class="btn btn-warning btn-lg"> -->
								<a href="smsBuyCondition.do?sb_no=${board.sb_no}&price=${board.qst_price}&pageNum=${pageNum}" class="btn btn-warning btn-lg">완료하기</a>
							</c:if>
							<c:if test="${board.qst_comp%2!=0}">
								<button class="btn btn-success btn-lg" disabled="disabled">거래 완료</button>
							</c:if>
						</td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
	</div>
</body>
</html>