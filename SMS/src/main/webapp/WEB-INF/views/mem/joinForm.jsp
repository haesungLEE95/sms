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
		if (!frm.mem_id.value) {	alert("아이디 입력후에 체크하시오");
			frm.mem_id.focus(); return false;  	}
		$.post('idChk.html','mem_id='+frm.mem_id.value, function(data) {
			$('#disp').html(data);
		});
	}
</script>
<style type="text/css">
.tbl { width: 500px}
</style>
</head>
<body>
	<div class="container" align="center">
		<h2 class="text-primary">회원가입</h2>
		<div class="tbl">
		<form action="joinForm2.do" name="frm" method="post">
		<table class="table table-hover" >
			<tr><th width="120px"><span class="glyphicon glyphicon-user"/>아이디</th><td width="400px">
			<input type="text" name="mem_id" required="required" autofocus="autofocus">
<!-- 			<input type="button" onclick="idChk()" class="btn btn-info btn-sm" value="중복체크">
			<span id="disp" class="err"></span> -->
			</td></tr>
			<tr><th><span class="glyphicon glyphicon-lock"/>암호</th><td><input type="password" name="passwd" required="required"></td></tr>
			<tr><th><span class="glyphicon glyphicon-tag"/>이름</th><td><input type="text" name="mem_name" required="required"></td></tr>
			<tr><th><span class="glyphicon glyphicon-star-empty"/>닉네임</th><td><input type="text" name="nickname" required="required"></td></tr>
			<tr><th><span class="glyphicon glyphicon-file"/>이메일</th><td><input type="text" name="email" required="required"></td></tr>
			<tr><th colspan="2"><input type="submit"></th></tr>
		</table>
		</form>
		</div>
	</div>
</body>
</html>
