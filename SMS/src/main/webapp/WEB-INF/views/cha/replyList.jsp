<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <script type="text/javascript">
	function rDelete(bno, rno) {
		var sendData = "bro=" + bno + "&rno=" +rno;
		$.post('${path}/rDelete', sendData, function(data) {
			alert('삭제되었습니다');
			$('#rbdListDisp').html(data);
		});
	}
	function rUpdate(bno,rno) {
		var txt = $('#td_'+rno).text();
		$('#td_'+rno).html('<textarea row="3" col="30" id="rt">'+txt+'</textarea>');
		$('#btn_'+rno).html('<button onclick="up('+bno+','+rno+')" class="btn btn-sm btn-danger">확인</button>'+
							'<button onclick="lst('+bno+')" class="btn btn-sm btn-info">취소</button>');
	}
	function up(bno, rno) {
		var sendData = "replytext="+$('#rt').val()+"&bno="+bno+"&rno="+rno;
		$.post('${path}/rUpdate', sendData, function(data) {
			alert('댓글수정완료');
			$('#rbdListDisp').html(data);
		});
	}
	function lst(bno) {
		$('#rbdListDisp').load('${path}/replyList/bno/'+bno);
	}
</script> -->
</head>
<body>
<div class="container">
		<h2 class="text-primary">댓글 목록</h2>
		<table class="table table-striped">
			<tr><td>작성자</td><td>내용</td><td>작성일</td></tr>
			<c:if test="${empty rbdList }">
				<tr><td colspan="4">댓글없음</td></tr>
			</c:if>
			<c:if test="${not empty rbdList }">
			<c:forEach var="rbd" items="${rbdList }">
				<c:if test="${rbd.del=='y'}">
					<tr><td colspan="4">삭제된 댓글입니다</td></tr>
				</c:if>
				<c:if test="${rbd.del!='y'}">
					<tr>
					<td>${rbd.mem_no}</td>
					<td id="td_${rbd.rep_no }">${rbd.cha_re_cont}</td>
					<td>${rbd.updatedate}</td>
					<!-- 원래는  댓글작성자와 로그인한 사람과 비교 -->
					<td id="btn_${rbd.rep_no }">
						<c:if test="${rbd.mem_no==memNick}">
							<button class="btn btn-sm btn-warning"
								onclick="rUpdate(${rbd.cha_no},${rbd.rep_no })">수정</button>
							<button class="btn btn-sm btn-danger"
								onclick="rDelete(${rbd.cha_no},${rbd.rep_no })">삭제</button>
						</c:if>
					</td>
					</tr>
				</c:if>
			</c:forEach></c:if>
		</table>
	</div>
</body>
</html>