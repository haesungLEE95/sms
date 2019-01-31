<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<!DOCTYPE html><html><head><meta charset="UTF-8">
<title>SMS : 포인트 충전</title></head><body>
<c:if test="${result >0 }">
	<script type="text/javascript">
		alert("충전이 완료되었습니다");
/* 		location.href="myPage.do"; */
		opener.parent.location.reload();
		self.close();
	</script>
</c:if>
<c:if test="${result == 0 }">
	<script type="text/javascript">
		alert("암호가 다릅니다");
		history.go(-1);
	</script>
</c:if>
<c:if test="${result == -1 }">
	<script type="text/javascript">
		alert("오류가 발생하였습니다");
		history.go(-1);
	</script>
</c:if>
</body>
</html>