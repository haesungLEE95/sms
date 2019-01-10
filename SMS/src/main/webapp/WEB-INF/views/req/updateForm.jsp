<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html><html><head><meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function chk() {
		if (frm.passwd.value != frm.passwd2.value) {
			alert("암호가 다릅니다");
			frm.passwd2.focus(); frm.passwd2.value = "";
			return false;
		}
	}
</script></head><body>
<div class="container">
	<h2>게시글 수정</h2>
<form action="update.do" method="post"   name="frm" 
		onsubmit="return chk()">
	<input type="hidden" name="num" 	 value="${board.num}">
	<input type="hidden" name="passwd" 	 value="${board.passwd}">
	<input type="hidden" name="pageNum"  value="${pageNum}">
<table class="table table-hover">
	<tr><td>제목</td><td><input type="text" name="subject" 
		required="required" autofocus="autofocus"
		value="${board.subject}"></td></tr>
	<tr><td>작성자</td><td><input type="text" name="writer"
		required="required" value="${board.writer}"></td></tr>
	<tr><td>이메일</td><td><input type="email" name="email"
		required="required" value="${board.email}"></td></tr>
	<tr><td>암호확인</td><td><input type="password" name="passwd2"
		required="required"></td></tr>
	<tr><td>내용</td><td><pre><textarea rows="5" cols="40" 
		name="content" required="required">${board.content}
		</textarea></pre></td></tr>
	<tr><td colspan="2"><input type="submit" value="확인"></td></tr>
</table></form>
</div>
</body>
</html>