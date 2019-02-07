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
		$('#qnarbdListDisp').load('qnaReplyList.do?qna_no=${smsqna.qna_no}');
		$('#qnaReInsert').click(function() {
			if (!frm.qna_re_cont.value) {
				alert("댓글을 입력후에 사용하세요");
				frm.qna_re_cont.focus();
				return false;
			}
			/* var sendData = 'cha_no='+$('#cha_no').val()+
				"&mem_no="+$('#mem_no').val()+
				"&cha_re_cont="+$('#cha_re_cont').val();  */
				var sendData = $('#frm').serialize(); 
			$.post('qnaReplyInsert.do', sendData, function(data) {
				alert("댓글이 작성되었습니다");
				$('#qnarbdListDisp').html(data);
				frm.qna_re_cont.value = "";
			});
		});
	});
</script>
</head>
<body>
<div class="container" align="center">
	<h2>문의사항</h2>
	<table class="table table-hover">
		<tr><td>제목</td></tr><tr><td>${smsqna.sms_qna}</td></tr>
		<tr><td>작성자</td></tr><tr><td>${sm.nickname}</td></tr>
		<tr><td>작성일</td></tr><tr><td>${smsqna.qna_date}</td></tr>
		<tr><td>내용</td></tr><tr><td><pre>${smsqna.qna_cont}</pre></td></tr>
		<tr><td colspan="2">
			<div align="center">
			<a class="btn btn-info" href="smsQnAList.do?pageNum=${pageNum}">문의목록</a>
			</div>
			</td></tr>
	</table>
	<h3 class="text-primary">댓글 작성</h3>
		<form name="frm" id="frm">
			<input type="hidden" name="qna_no" value="${smsqna.qna_no}">
			<input type="hidden" name="mem_no" value="${mem_no}">
			<%-- <input type="hidden" name="qna_rep" value="${smsqna.qna_rep}"> --%>
			<table class="table table-hove">
				<tr><td>작성자</td><td>${nickname}</td></tr>
				<tr>
					<td>댓글</td>
					<td><textarea rows="3" cols="30" name="qna_re_cont"></textarea>
					<input type="button" value="댓글입력" id="qnaReInsert"></td>
				</tr>
			</table>
		</form>
		<div id="qnarbdListDisp"></div>
</div>
</body>
</html>