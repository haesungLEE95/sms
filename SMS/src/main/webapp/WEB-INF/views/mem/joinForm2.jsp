<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>추가정보 입력</title>
<style type="text/css">
.tbl { width: 350px}
</style>
</head>
<body>
<div class="container" align="center">
<c:if test="${result >0 }">
	<script type="text/javascript">
	alert("추가 정보를 입력해주세요");
/* 	location.href="loginForm.html"; */
	</script>
		<h2 class="text-primary">추가정보 입력</h2>
		<div class="tbl">
		<form action="joinResult.do" name="frm" method="post" enctype="multipart/form-data">
		<table class="table table-hover" >
			<tr><th width="120px"><input type="hidden" name="mem_id" value="${mem_id }"><span class="glyphicon glyphicon-user"/>프로필</th></tr>
			<tr><td width="400px"><input type="file" name="mem_img" value="${mem.mem_img }"></td></tr>
			</td></tr>
			<tr><th><span class="glyphicon glyphicon-lock"/>주소</th></tr>
			<tr><td><input type="text" name="addr" autofocus="autofocus"></td></tr>
			<tr><th><span class="glyphicon glyphicon-tag"/>전화번호</th></tr>
			<tr><td><input type="tel" name="tel" ></td></tr>
			<tr><th><span class="glyphicon glyphicon-file"/>계좌번호</th></tr>
			<tr><td><input type="text" name="mem_account"></td></tr>
			<tr><th colspan="2" align="center"><div align="center"><input class="btn btn-info" type="submit"><a href="joinResult.do" class="btn btn-info">스킵</a></div></th></tr>
		</table>
		</form>
		</div>
</c:if>
<c:if test="${result == -1 }">
	<script type="text/javascript">
	alert("이미 사용중인 아이디입니다");
	history.go(-1)
	</script>
</c:if>
<c:if test="${result == 0 }">
	<script type="text/javascript">
	alert("입력 실패");
	history.go(-1)
	</script>
</c:if>
</div>
</body>
</html>