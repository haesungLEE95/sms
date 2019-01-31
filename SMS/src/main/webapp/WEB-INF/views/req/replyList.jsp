<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script type="text/javascript">
		function smsReqrDelete(rq_no, rq_re_no) {
			var sendData = "rq_no="+rq_no+"&rq_re_no="+rq_re_no;
			$.post('smsReqrDelete.do', sendData, function(data) {
				alert("댓글이 삭제되었습니다");
				$('#rbdListDisp').html(data);
			});
		}
		function smsReqrUpdate(rq_no, rq_re_no) {
			var txt =$('#td_'+rq_re_no).text();
			$('#td_'+rq_re_no).html('<textarea rows="3" cols="30" id="rt">'+txt+'</textarea>');
			$('#btn_'+rq_re_no).html('<button onclick="up('+rq_no+', '+rq_re_no+')" class="btn btn-sm btn-danger">수정완료</button>'+
				'<button onclick="lst('+rq_no+')" class="btn btn-sm btn-info">취소</button>');
		}
		function up(rq_no, rq_re_no) {
			var sendData = "rq_re_cont="+$('#rt').val()+
				"&rq_no="+rq_no+"&rq_re_no="+rq_re_no;
			$.post('smsReqrUpdate.do', sendData, function(data) {
				alert("댓글 수정 완료");
				$('#rbdListDisp').html(data);
			});
		}
		function lst(rq_no) {
			$('#rbdListDisp').load('smsReqreplyList.do?rq_no='+rq_no);
		}
	</script>
</head>
<body>
	<div class="container" align="center">
		<h2 class="text-primary">댓글 목록</h2>
		<table class="table table-hover">
			<tr><td>작성자</td><td>내용</td><td>작성일</td><td></td></tr>
			<c:if test="${empty rbdList}">
				<tr><td colspan="4">댓글없음</td></tr>
			</c:if>
			<c:if test="${not empty rbdList}">
				<c:forEach var="rbd" items="${rbdList }">
					<c:if test="${rbd.del=='y' }">
						<tr><td colspan="4">삭제된 댓글입니다.</td></tr>
					</c:if>
					<c:if test="${rbd.del=='n' }">
						<tr><td>${rbd.mem_no }</td>
							<td id="td_${rbd.rq_re_no }">${rbd.rq_re_cont }</td>
							<td>${rbd.updatedate }</td>
							<td id="btn_${rbd.rq_re_no }">
							<c:if test="${rbd.mem_no==smsReq.mem_no }">
								<button class="btn btn-sm btn-warning"
									onclick="smsReqrUpdate(${rbd.rq_no},${rbd.rq_re_no })">수정</button>
								<button class="btn btn-sm btn-danger"
									onclick="smsReqrDelete(${rbd.rq_no},${rbd.rq_re_no })">삭제</button>
							</c:if></td>
					</c:if>
				</c:forEach>
			</c:if>
		</table>
	</div>
</body>
</html>