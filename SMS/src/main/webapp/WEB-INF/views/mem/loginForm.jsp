<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<head>
<meta charset="UTF-8">
<title>SMS : 로그인</title>
<style type="text/css">
.login { width: 330px}
</style>
</head>
<body>
	<div class="container" align="center">
		<h2 class="text-primary">SellMySelf!</h2>
		<br>
		<div class="login">
		<form action="login.do" method="post">
			<table class="table table-striped table-bordered">
				<tr>
					<td><span class="glyphicon glyphicon-user"/>아이디</td>
					<td><input type="text" name="mem_id" required="required"
						autofocus="autofocus"></td>
				</tr>
				<tr>
					<td><span class="glyphicon glyphicon-lock"/>암호</td>
					<td><input type="password" name="passwd" required="required"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="확인"
						class="btn btn-warning"></td>
				</tr>
			</table>
			<div align="right"><a href="joinForm.do" class="btn btn-info">회원가입</a>
			</div>
		</form>
		</div>
	</div>
</body>
</html>