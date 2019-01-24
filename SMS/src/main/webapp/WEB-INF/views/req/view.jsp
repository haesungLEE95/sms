<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html><html><head><meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	$(function() {
		$('#boardListDisp').load('list.do?pageNum=${pageNum}');
		$('#rbdListDisp').load('smsReqreplyList.do?rq_no=${smsReq.rq_no}');
		$('#smsReqrInsert').click(function() {
			if (!frm.rq_re_cont.value) {
				alert("댓글을 입력후에 사용하시오");
				frm.rq_re_cont.focus(); return false; }
	/* 		var sendData = 'bno='+frm.bn+o.value+
						"&replyer="+frm.replyer+value+
						"&replytext="+frm.replytext.value; */
			var sendData = $('#frm').serialize();
			$.post('smsReqrInsert.do',sendData, function(data) {
				alert("댓글이 작성되었습니다");
				$('#rbdListDisp').html(data);
				frm.rq_re_cont.value = "";
			});
		});
	});
</script></head><body>
<div class="container" align="center">
	<h2>게시글 상세내역</h2>
	<table class="table table-hover">
		<tr><td>게시글번호</td><td>${smsReq.rq_no}</td></tr>
		<tr><td>제목</td><td>${smsReq.rq_title}</td></tr>
		<tr><td>카테고리</td>
			<td>
				<c:forEach var="mcate" items="${mcateList }">
					<c:if test="${mcate.mcate_no==smsReq.mcate_no }">
						 <span class="label label-info">${mcate.mcate_name }</span>
					</c:if>
				</c:forEach>
				<c:forEach var="scate" items="${scateList }">
					<c:if test="${scate.scate_no==smsReq.scate_no }">
						<span class="label label-info">${scate.scate_name }</span>
					</c:if>
				</c:forEach>
			</td>
		</tr>
		<tr><td>작성자</td><td>${smsReq.mem_no}</td></tr>
		<tr><td>내용</td><td><pre>${smsReq.rq_cont}</pre></td></tr>
		<tr><td>조회수</td><td>${smsReq.rq_count}</td></tr>
		<tr><td>작성일</td><td>${smsReq.rq_date}</td></tr>
		<tr><td>희망가격</td><td>${smsReq.rq_price}</td></tr>
		<tr><td>의뢰현황</td>
			<td>
				<c:if test="${smsReq.rq_cond%2==0}">
					<a class="btn btn-primary btn-lg" href="condition.do?num=${smsReq.rq_no}&pageNum=${pageNum}">의뢰 중</a>
				</c:if>
				<c:if test="${smsReq.rq_cond%2!=0}">
					<a class="btn btn-success btn-lg" href="condition.do?num=${smsReq.rq_no}&pageNum=${pageNum}">완료</a>
				</c:if>
			</td>
		</tr>
		<tr><td colspan="2">
			<a class="btn btn-info" href="list.do?pageNum=${pageNum}">게시글 목록</a>
			<%-- <c:if test=""> 작성자가 본인일 때 --%>
				<a href="updateForm.do?num=${smsReq.rq_no}&pageNum=${pageNum}" class="btn btn-warning">수정</a>
				<a href="delete.do?num=${smsReq.rq_no}&pageNum=${pageNum}" class="btn btn-danger">삭제</a>
			<%-- </c:if> --%></td></tr>
	</table>
	<h3 class="text-primary">댓글 작성</h3>
		<form name="frm" id="frm">
			<input type="hidden" name="rq_no" value="${smsReq.rq_no}">
			<input type="hidden" name="mem_no" value="1">
			<table class="table table-hover">
				<!-- 원래는 login한 사람 이름 또는 ID -->
				<tr>
					<td>작성자</td>
					<td>로그인정보불러오기</td>
					<td>댓글</td>
					<td><textarea rows="3" cols="30" name="rq_re_cont"></textarea></td>
					<td colspan="2"><input type="button" value="댓글입력" id="smsReqrInsert"></td>
				</tr>
			</table>
		</form>
		<div id="rbdListDisp"></div>
		<div id="boardListDisp"></div>
</div>
</body>
</html>