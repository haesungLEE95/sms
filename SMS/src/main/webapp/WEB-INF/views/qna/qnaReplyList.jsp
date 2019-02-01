<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
 	function qnaReplyDelete(qna_rep, qna_no) {
		var sendData = "qna_rep=" + qna_rep + "&qna_no=" +qna_no;
		$.post('qnaReplyDelete.do', sendData, function(data) {
			alert('삭제되었습니다');
			$('#rbdListDisp').html(data);
		});
	} 
	function qnaReplyUpdate(qna_rep,qna_no) {
		var txt = $('#td_'+qna_no).text();
		$('#td_'+qna_no).html('<textarea row="3" col="30" id="rt">'+txt+'</textarea>');
		$('#btn_'+qna_no).html('<button onclick="up('+qna_rep+','+qna_no+')" class="btn btn-sm btn-danger">확인</button>'+
							'<button onclick="lst('+qna_rep+')" class="btn btn-sm btn-info">취소</button>');
	}
 	function up(qna_rep, qna_no) {
		var sendData = "qna_re_cont="+$('#rt').val()+"&qna_rep="+qna_rep+"&qna_no="+qna_no;
		$.post('qnaReplyUpdate.do', sendData, function(data) {
			alert('댓글수정완료');
			$('#rbdListDisp').html(data);
		});
	}
	function lst(qna_no) {
		$('#rbdListDisp').load('qnaReplyList.do?qna_no'+qna_no);
	}
</script> 
</head>
<body>
	<div class="container" align="center">
		<h2 class="text-primary" align="center">댓글 목록</h2>
		<table class="table table-striped">
			<tr>
				<td>작성자</td>
				<td>내용</td>
				<td>작성일</td>
			</tr>
			<c:if test="${empty rbdList }">
				<tr>
					<td colspan="4">댓글없음</td>
				</tr>
			</c:if>
			<c:if test="${not empty rbdList }">
				<c:forEach var="rbd" items="${rbdList }">
					<c:if test="${rbd.del=='y'}">
						<tr>
							<td colspan="4">삭제된 댓글입니다</td>
						</tr>
					</c:if>
					<c:if test="${rbd.del!='y'}">
						<tr>
							<td>${rbd.nickname}</td>
							<td id="td_${rbd.qna_rep }">${rbd.qna_re_cont}</td>
							<td>${rbd.updatedate}</td>
							<!-- 원래는  댓글작성자와 로그인한 사람과 비교 -->
							<td id="btn_${rbd.qna_rep }"><c:if
									test="${rbd.mem_no==mem_no}">
									<button class="btn btn-sm btn-warning"
										onclick="qnaReplyUpdate(${rbd.qna_no},${rbd.qna_rep })">수정</button>
									<button class="btn btn-sm btn-danger"
										onclick="qnaReplyDelete(${rbd.qna_no},${rbd.qna_rep })">삭제</button>
								</c:if></td>
						</tr>
					</c:if>
				</c:forEach>
			</c:if>
		</table>
	</div>
</body>
</html>