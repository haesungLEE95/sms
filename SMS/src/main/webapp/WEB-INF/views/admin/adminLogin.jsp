<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

<c:if test="${result == 1}">
	<script type="text/javascript">
		alert("${sa.admin_id}님 환영합니다.");
		location.href="adminMain.do";
	</script>
</c:if>
<c:if test="${result == 0}">
	<script type="text/javascript">
		alert("비밀번호를 다시 확인하세요");
		history.go(-1);
	</script>
</c:if>
<c:if test="${result == -1}">
	<script type="text/javascript">
		alert("아이디를 다시 확인해주세요");
		history.go(-1);
	</script>
</c:if>

</body>
</html>