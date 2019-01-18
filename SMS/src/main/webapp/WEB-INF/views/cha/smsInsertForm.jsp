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
	<form action="smsInsert.do">
		<%-- <input type="hidden" name="ref" value="${ref }">
		<input type="hidden" name="re_level" value="${re_level }">
		<input type="hidden" name="re_step" value="${re_step }">
		<input type="hidden" name="num" value="${num }">
		<input type="hidden" name="pageNum" value="${pageNum }"> --%>
		<input type="hidden" name="mem_no" value="1">
		<input type="hidden" name="cha_id" value="aaa">
		<table class="table table-hover">
			<tr>
				<td>제목</td>
				<td><input type="text" name="cha_title" required="required" autofocus="autofocus"></td>
			</tr>
			<tr>
				<td>작성자</td>
				<%-- <td><a value="${mem_no}에 있는 nickname 가져오기 "></a></td> --%>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="5" cols="40" name="cha_cont" required="required"></textarea></td>
			</tr>
			<tr><td colspan="2"><input type="submit" value="확인" >
			<input type="button" value="취소" onclick="location.href='smsChaList.do'"></td></tr>
 		</table>
	</form>
</div>
</body>
</html>