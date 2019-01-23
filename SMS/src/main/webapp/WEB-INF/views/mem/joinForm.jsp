<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function idChk() {
		if (!frm.id.value) {	alert("아이디 입력후에 체크하시오");
			frm.id.focus(); return false;  	}
		$.post('idChk.html','id='+frm.id.value, function(data) {
			$('#disp').html(data);
		});
	}
</script>
</head>
<body>
	<div class="container" align="center">
		<h2 class="text-primary">회원가입</h2>
		<form action="join.html" name="frm" method="post">
		<table class="table table-hover">
			<tr><th><span class="glyphicon glyphicon-user"/>아이디</th><td><input type="text" name="id" required="required" autofocus="autofocus">
			<input type="button" onclick="idChk()" class="btn btn-info btn-sm" value="중복체크">
			<span id="disp" class="err"></span>
			</td></tr>
			<tr><th><span class="glyphicon glyphicon-lock"/>암호</th><td><input type="password" name="password" required="required"></td></tr>
			<tr><th>이름</th><td><input type="text" name="name" required="required"></td></tr>
			<tr><th><span class="glyphicon glyphicon-envelope"/>이메일</th><td><input type="text" name="email" required="required"></td></tr>
			<tr><th colspan="2"><input type="submit"></th></tr>
			</table>
		</form>
	</div>
</body>
</html>
