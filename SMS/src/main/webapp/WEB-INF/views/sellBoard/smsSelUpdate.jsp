<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html><html><head><meta charset="UTF-8">
<title>Insert title here</title></head><body>
<c:if test="${result > 0 }">
	<script type="text/javascript">
		alert("수정완료 대박 !!");
		location.href="smsSellBoardView.do?num=${smssel.sb_no}&pageNum=${pageNum}";
		// location.href="list.do?pageNum=${pageNum}";
	</script>
</c:if>
<c:if test="${result == 0 }">
	<script type="text/javascript">
		alert("똑바로 해! 알간 !!");
		history.go(-1);
	</script>
</c:if>
</body>
</html>