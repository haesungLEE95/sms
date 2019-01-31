<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>포인트 충전</title>
<script type="text/javascript">
function chk() {
	if (!frm.passwd.value){
		alert("비밀번호를 입력해주세요")
		frm.passwd.value = "";
		frm.passwd.focus();
		return false;
		
	};
}
</script>
</head>
<body>
<div class="container">
<h2 align="center">포인트 충전</h2>
<br>
<form action="chargeMnyResult.do" name="frm" method="post" onsubmit="return chk()">
<input type="hidden" name="mem_no" value="${mem.mem_no }">
<input type="hidden" name="mem_id" value="${mem.mem_id }">
<div align="center">
<span><input id="mny1" name="mny" type="radio" value="5000"/><label for="mny1">5,000원</label></span>
<span><input id="mny2" name="mny" type="radio" value="10000"/><label for="mny2">10,000원</label></span>
<span><input id="mny3" name="mny" type="radio" value="30000"/><label for="mny3">30,000원</label></span>
<span><input id="mny4" name="mny" type="radio" value="50000"/><label for="mny4">50,000원</label></span>
<span><input id="mny5" name="mny" type="radio" value="100000"/><label for="mny5">100,000원</label></span>
<br>
<br>
비밀번호 입력 : <input type="password" name="passwd"><br><br>
<input type="submit" class="btn btn-info" value="충전">
</div>
</form>
</div>
</body>
</html>