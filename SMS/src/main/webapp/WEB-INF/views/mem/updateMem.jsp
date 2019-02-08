<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<!DOCTYPE html><html><head><meta charset="UTF-8">
<title>SMS : 로그인</title></head><body>
<c:if test="${result >0 }">
	<script type="text/javascript">
		alert("수정이 완료되었습니다");
		location.href="myPage.do";
	</script>
</c:if>
<c:if test="${result == 0 }">
	<script type="text/javascript">
		alert("리절트가 0일 경우입니다");
		history.go(-1);
	</script>
</c:if>
<c:if test="${result == -1 }">
	<script type="text/javascript">
		alert("리절트 -1입니다");
		history.go(-1);
	</script>
</c:if>
</body>
</html>