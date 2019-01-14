<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<head>
<meta charset="UTF-8">
<title>SMS : 로그인</title>
</head>
<body>
	<div class="container" align="center">
		<h2 class="text-primary">로그인</h2>
		<form action="login.do">
			<table class="table table-striped table-bordered">
				<tr>
					<td>아이디</td>
					<td><input type="text" name="mem_id" required="required"
						autofocus="autofocus"></td>
				</tr>
				<tr>
					<td>암호</td>
					<td><input type="password" name="passwd" required="required"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="확인"
						class="btn btn-warning"></td>
				</tr>
			</table>
			<a href="joinForm.do" class="btn btn-info">회원가입</a>
		</form>
	</div>
</body>
</html>