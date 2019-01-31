<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="httpRequest.js"></script>
<script type="text/javascript">
	function passwdChk() {
		var f1 = document.forms[0];
		var pw1 = frm.passwd.value;
		var pw2 = frm.passwdCheck.value;
		if (pw1 != pw2) {
			document.getElementById('checkPwd').style.color = "red";
			document.getElementById('checkPwd').innerHTML = "동일한 암호를 입력하세요.";
			return false;
		} else {
			document.getElementById('checkPwd').style.color = "green";
			document.getElementById('checkPwd').innerHTML = "암호가 확인 되었습니다.";
		}
	};
	function nickChk() {
		if (!frm.nickname.value) {
			alert("닉네임 입력 후에 체크하세요");
			frm.nickname.focus();
			return false;
		}
		$.post('nickChk.do', 'nickname=' + frm.nickname.value, function(data) {
			$('#disp2').html(data);
		});
	};
</script>
<style type="text/css">
.nameSpace {
	font-size: small;
	font-weight: bold;
}

#updateTable {
	width: 340px;
}

#disp2 {
	margin-top: 1px
}
#checkPwd {
	font-weight: bold;
}

</style>
</head>
<body>
	<div class="container" align="center">
		<h3>회원정보 수정</h3>
		<br>
		<form id="updateForm" name="frm" action="updateMem.do" method="post">
			<table id="updateTable" class="table table-striped">
				<tr>
					<td class="nameSpace">이름</td>
				</tr>
				<tr>
					<td><font color="gray">${mem.mem_name }</font></td>
				</tr>
				<tr>
					<td class="nameSpace">아이디</td>
				</tr>
				<tr>
					<td><font color="gray"><input type="hidden"
							name="mem_id" value="${mem.mem_id }">${mem.mem_id }</font></td>
				</tr>
				<tr>
					<td class="nameSpace">닉네임</td>
				</tr>
				<tr>
					<td><input type="text" name="nickname"
						placeholder="${mem.nickname }"> <input type="button"
						onclick="nickChk()" class="btn btn-info btn-sm" value="중복체크">
						<div id="disp2" class="err"></div></td>
				</tr>
				<tr>
					<td class="nameSpace">이메일</td>
				</tr>
				<tr>
					<td><input type="email" name="email"
						value="${mem.email }"></td>
				</tr>
				<tr>
					<td class="nameSpace">비밀번호</td>
				</tr>
				<tr>
					<td><input type="password" name="passwd"></td>
				</tr>
				<tr>
					<td class="nameSpace">비밀번호확인</td>
				</tr>
				<tr>
					<td><input type="password" name="passwdCheck"
						onkeyup="passwdChk();"><br>
						<div id="checkPwd"></div></td>
				</tr>
				<tr>
					<td class="nameSpace">주소</td>
				</tr>
				<tr>
					<td><input type="text" name="addr" value="${mem.addr }"></td>
				</tr>
				<tr>
					<td class="nameSpace">전화번호</td>
				</tr>
				<tr>
					<td><input type="text" name="tel" value="${mem.tel }"></td>
				</tr>
				<tr>
					<td class="nameSpace">계좌번호</td>
				</tr>
				<tr>
					<td><input type="text" name="mem_account"
						placeholder="${mem.mem_account }"></td>
				</tr>
				<tr>
					<td class="nameSpace">회원가입일</td>
				</tr>
				<tr>
					<td><font color="gray">${mem.mem_reg }</font></td>
				</tr>
				<tr>
					<td align="center"><input type="submit" class="btn btn-info"
						value="수정"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>