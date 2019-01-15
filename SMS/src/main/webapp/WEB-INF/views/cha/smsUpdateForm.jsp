<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<h2>게시글 수정</h2>
	<form action="smsUpdate.do">
		<input type="hidden" name="mem_no" value="1">
		<input type="hidden" name="cha_id" value="a">
		<table class="table table-hover">
			<tr>
				<td>제목</td>
				<td><input type="text" name="subject" required="required" autofocus="autofocus"
						value="${cha.cha_title }"></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>${memNick}</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td>${cha.cha_ }</td>
			</tr>
			<tr>
				<td>내용</td>
				<td><pre><textarea rows="5" cols="40" 
					name="content" required="required">${cha.content}</textarea></pre></td>
			</tr>
			<tr><td colspan="2"><input type="submit" value="확인"></td></tr>
 		</table>
	</form>
</div>
</body>
</html>