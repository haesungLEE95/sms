<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 로그인</title>
<link rel="stylesheet" type="text/css" href="css/login.css" >
</head>
<body>

<div class="container" align="center" style="width: 1280px; height: 680px; padding: 50px 0 100px 0">
	<h2 style="color: #503396;" align="center">관리자 로그인</h2>
	<div class="mainbox">
		<form action="adminLogin.do" method="post" class="form-inline" style="width:400px; height: 125px;">
		  
		  <div class="mainbox2">
			<div class="form-group" style="padding: 20px 20px;">
				<input type="text" name="admin_id" class="form-control" placeholder="아이디" required="required" autofocus="autofocus">
			</div><br>
			<div class="form-group">
				<input type="password" name="passwd" class="form-control" placeholder="비밀번호" required="required">
			</div><br>
			<div class="mainbox4">
				<button type="submit" value="확인"  class="btn"><img width="75px;" height="58px;" src="img/btn_login2.png" onmouseover="this.src='img/btn_login.png'" onmouseout="this.src='img/btn_login2.png'"></button>
		 	</div>
		  </div>
	<!-- 		<div class="mainbox3"> 
				<a href="insertForm.do"><img src="img/btn_member1.png" onmouseover="this.src='img/btn_member2.png'" onmouseout="this.src='img/btn_member1.png'"></a>
			</div> -->
			
		</form>
	</div>
</div>

</body>
</html>