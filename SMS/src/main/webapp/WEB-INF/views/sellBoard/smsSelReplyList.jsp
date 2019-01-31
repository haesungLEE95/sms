<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script type="text/javascript">
		function smsReviewDelete(sb_no, re_no) {
			var sendData = "sb_no="+sb_no+"&re_no="+re_no;
			$.post('smsReviewDelete.do', sendData, function(data) {
				alert("댓글이 삭제되었습니다");
				$('#rbdListDisp').html(data);
			});
		}
		function smsReviewUpdate(sb_no, re_no) {
			var txt =$('#td_'+re_no).text();
			$('#td_'+re_no).html('<textarea rows="3" cols="30" id="rt">'+txt+'</textarea>');
			$('#btn_'+re_no).html('<button onclick="up('+sb_no+', '+re_no+')" class="btn btn-sm btn-danger">수정완료</button>'+
				'<button onclick="lst('+sb_no+')" class="btn btn-sm btn-info">취소</button>');
		}
		function up(sb_no, re_no) {
			var sendData = "re_cont="+$('#rt').val()+
				"&sb_no="+sb_no+"&re_no="+re_no;
			$.post('smsReviewUpdate.do', sendData, function(data) {
				alert("댓글 수정 완료");
				$('#rbdListDisp').html(data);
			});
		}
		function lst(rq_no) {
			$('#rbdListDisp').load('smsReviewList.do?sb_no='+sb_no);
		}
	</script>
</head>
<body>
	<div class="container" align="center">
		<h2 class="text-primary">댓글 목록</h2>
		<table class="table table-hover">
			<tr><td>작성자</td><td>내용</td><td>평점</td><td></td></tr>
			<c:if test="${empty rbdList}">
				<tr><td colspan="4">댓글없음</td></tr>
			</c:if>
			<c:if test="${not empty rbdList}">
				<c:forEach var="rbd" items="${rbdList }">
						<tr><td>${rbd.nickname }</td>
							<td id="td_${rbd.re_no }">${rbd.re_cont }</td>
							<td>${rbd.re_score }</td>
							<td id="btn_${rbd.re_no }">
							<c:if test="${rbd.mem_no==mem_no }">
								<button class="btn btn-sm btn-warning"
									onclick="smsReviewUpdate(${rbd.sb_no},${rbd.re_no })">수정</button>
								<button class="btn btn-sm btn-danger"
									onclick="smsReviewDelete(${rbd.sb_no},${rbd.re_no })">삭제</button>
							</c:if></td></tr>

				</c:forEach>
			</c:if>
		</table>
	</div>
</body>
</html>