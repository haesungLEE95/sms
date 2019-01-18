<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> SellMySelf에 가입하신 것을 축하합니다! </title>
<style type="text/css">
.button { valign: center }
</style>
</head>
<body>
<div class="container" align="center">
<%-- <c:if test="${result >0 }"> --%>
		<div class="button">
		<%-- <input type="hidden" name="mem_id" value="${mem.mem_id }">
		<input type="hidden" name="passwd" value="${mem.passwd }"> --%>
		<button onclick="myPage.do" class="btn btn-info"> SellMySelf에 가입하신 것을 축하합니다!
		</div>
</div>
<%-- </c:if> --%>
<%-- <c:if test="${result == 0 }">
	<script type="text/javascript">
	alert("입력 실패");
	history.go(-1)
	</script>
</c:if> --%>
</div>
</body>
</html>