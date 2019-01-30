<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<!DOCTYPE html><html><head><meta charset="UTF-8">
<title>Insert title here</title></head><body>
<c:if test="${result > 0 }">
	<script type="text/javascript">
		alert("의뢰 성공 ㅋㅋ");
		location.href="smsSellBoardView.do?num=${smsqna.sb_no }&pageNum=${pageNum}";
	</script>
</c:if>
<c:if test="${result == 0 }">
	<script type="text/javascript">
		alert("으이그 화상 !!");
		history.go(-1);
	</script>
</c:if>
</body>
</html>