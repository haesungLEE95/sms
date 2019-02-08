<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h2>게시글 입력</h2>
		<form action="smsQnAInsert.do" method="post" name="frm">
			<input type="hidden" name="sb_no" value="${sb_no}"> 
			<input type="hidden" name="pageNum" value="${pageNum}">
			<input type="hidden" name="mem_no" value="${mem_no}">
			<table class="table table-hover">
				<tr>
					<td>제목 </td>
					<td><input type="text" name="sms_qna" required="required"
						autofocus="autofocus"></td>
				</tr>
				<tr>
					<td>작성자</td>
					<td>${nickname}</td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea rows="5" cols="40" name="qna_cont"
							required="required"></textarea></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="확인"> <input
						type="button" value="취소" onclick="location.href='smsSelView.do'"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>