<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	$(function() {
		// $('#boardListDisp').load('smsmChaList.do?'); 
		$('#rbdListDisp').load('replyList.do?cha_no=${smscha.cha_no}');
		$('#rInsert').click(function() {
			if (!frm1.cha_re_cont.value) {
				alert("댓글을 입력후에 사용하세요");
				frm1.cha_re_cont.focus();
				return false;
			}
/* 			var sendData = 'cha_no='+$('#cha_no').val()+
				"&mem_no="+$('#mem_no').val()+
				"&cha_re_cont="+$('#cha_re_cont').val();  */
			var sendData = $('#frm1').serialize();
			//alert(sendData);
			$.post('rInsert.do', sendData, function(data) {
				alert("댓글이 작성되었습니다");
				$('#rbdListDisp').html(data);
				frm1.cha_re_cont.value = "";
			});
		});
	});
</script>
</head>
<body>
	<div class="container" align="center">
		<h2>상세보기</h2>
		<table class="table table-hover" style="align-content: center;">
			<tr>
				<td>제목</td>
				<td>${smscha.cha_title}</td>
			<tr>
			<tr>
				<td>작성자</td>
				<td>${sm.nickname}</td>
			<tr>
			<tr>
				<td>작성일</td>
				<td>${smscha.cha_date }</td>
			<tr>
			<tr>
				<td>내용</td>
				<td>${smscha.cha_cont }</td>
			<tr>
			<tr>
				<td colspan="2">
					<div align="center">
						<a class="btn btn-default" href="smsUpdateForm.do?num=${smscha.cha_no}&pageNum=${pageNum}">수정</a>
						<a class="btn btn-default" href="smsDelete.do?num=${smscha.cha_no}&pageNum=${pageNum}">삭제</a>
					</div>
					<p>
					<div align="center">
						<a class="btn btn-default" href="smsChaList.do?pageNum=${pageNum}">게시글목록</a>
					</div>
				</td>
			</tr>
		</table>
		<h3 class="text-primary">댓글작성</h3>
		<form name="frm1" id="frm1">
			<input type="hidden" name="cha_no" value="${smscha.cha_no}">
			<input type="hidden" name="mem_no" value="${mem_no }">
			<table class="table table-hove">
				<tr>
					<!-- 원래는 login한 사람 이름 또는 ID -->
					<td>작성자</td>
					<td>${nickname }</td>
					<td>댓글</td>
					<td><textarea rows="5" cols="30" name="cha_re_cont" id="cha_re_cont"></textarea></td>
					<td colspan="2"><input type="button" value="댓글입력" id="rInsert"></td>
				</tr>
				<!-- 화면안바뀌고 ajax처리를 위한 type=button -->
			</table>
		</form>
		<div id="rbdListDisp"></div>
		<!-- <div id="boardListDisp"></div> -->
	</div>
</body>
</html>