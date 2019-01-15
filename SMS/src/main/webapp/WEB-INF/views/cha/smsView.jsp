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
<div class="container" align="center"> 
	<h2>상세보기</h2>
	<table class="table table-hover">
		<tr><td>제목</td><td>${smscha.cha_title}</td><tr>
		<tr><td>작성자</td><td>${memNick}</td><tr>
		<tr><td>작성일</td><td>${smscha.cha_date }</td><tr>
		<tr><td>내용</td><td>${smscha.cha_cont }</td><tr>
		<tr><td colspan="2">
			<div align="center">
			<a class="btn btn-default" href="smsChaList.do">게시글목록</a>
			</div>
		</td>
		</tr>
	</table>
 		 <%-- <h3 class="text-primary">댓글작성</h3>
		<form name="frm" id="frm">
			<input type="hidden" name="bno" value="${smscha.cha_no}">
			<table class="table table-hove">
				<tr>
			 <!-- 원래는 login한 사람 이름 또는 ID -->
				<td>작성자</td>
				<td><input type="text" name="replyer" value="${board.writer}" size="4"></td>
				<td>댓글</td><td><textarea rows="3" cols="30" name="replytext"></textarea></td>
				<td colspan="2"><input type="button" value="댓글입력" id="rInsert"></td></tr>
					<!-- 화면안바뀌고 ajax처리를 위한 type=button -->
			 </table>
		</form> --%>
		<!-- <div id="rbdListDisp"></div>
		<div id="boardListDisp"></div>  -->
</div> 
</body>
</html>