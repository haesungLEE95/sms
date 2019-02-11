<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<!DOCTYPE html><html><head><meta charset="UTF-8">
<title>Insert title here</title></head><body>
	<c:if test="${result == 2 }">
		<script type="text/javascript">
		alert("돈 모자람");
		location.href="smsSellBoardView.do?num=${sb_no }&pageNum=${pageNum}";
		</script>
	</c:if>
	<script type="text/javascript">
		alert("해당 상품은 완료 전 구매 내역이 있습니다.");
		location.href="smsSellBoardView.do?num=${sb_no }&pageNum=${pageNum}";
	</script>
</body>
</html>