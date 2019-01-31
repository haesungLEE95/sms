<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html><html><head><meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	$(function() {
		//$('#boardListDisp').load('smsSellBoardList.do?pageNum=${pageNum}');
		$('#rbdListDisp').load('smsReviewList.do?sb_no=${smssel.sb_no}');
		$('#smsReviewInsert').click(function() {
			if (!frm.re_cont.value) {
				alert("댓글을 입력후에 사용하시오");
				frm.re_cont.focus(); return false; }
			if (!frm.re_score.value) {
				alert("평가를 입력후에 사용하시오");
				frm.re_score.focus(); return false; }
	/* 		var sendData = 'bno='+frm.bn+o.value+
						"&replyer="+frm.replyer+value+
						"&replytext="+frm.replytext.value; */
			var sendData = $('#frm').serialize();
			$.post('smsReviewInsert.do',sendData, function(data) {
				alert("댓글이 작성되었습니다");
				$('#rbdListDisp').html(data);
				frm.re_cont.value = "";
			});
		});
	});
</script></head><body>
<div class="container" align="center">
	<h2>게시글 상세내역</h2>
	<table class="table table-hover">
		<tr><td>이미지</td><td><img src="images/DSC_6305.jpg" alt="..."></td></tr>
		<tr><td>게시글번호</td><td>${smssel.sb_no}</td></tr>
		<tr><td>제목</td><td>${smssel.sb_title}</td></tr>
		<tr><td>카테고리</td>
			<td>
				<c:forEach var="mcate" items="${mcateList}">
					<c:if test="${mcate.mcate_no==smssel.mcate_no}">
						 <span class="label label-info">${mcate.mcate_name}</span>
					</c:if> 
				</c:forEach>
 			<c:forEach var="scate" items="${scateList}">
 					<c:if test="${scate.scate_no==smssel.scate_no}">
						<span class="label label-info">${scate.scate_name}</span>
					</c:if> 
				</c:forEach>  
			</td>
		</tr>
		<tr><td>작성자</td><td>${sm.nickname}</td></tr>
		<tr><td>내용</td><td><pre>${smssel.sb_desc}</pre></td></tr>
		<tr><td>작성일</td><td>${smssel.sb_date}</td></tr>
		<tr><td>희망가격</td><td>${smssel.sb_price}</td></tr>
		<tr><td>의뢰현황</td></tr>
		<tr><td colspan="2">
			<div align="center">
			<a class="btn btn-info" href="smsSellBoardList.do?pageNum=${pageNum}">게시글 목록</a>
				<c:if test="${smssel.mem_no==mem_no}"> 
				<a href="smsSellBoardUpdateForm.do?num=${smssel.sb_no}&
					pageNum=${pageNum}" class="btn btn-warning">수정</a>
				<a href="smsSellBoardDelete.do?num=${smssel.sb_no}&
					pageNum=${pageNum}" class="btn btn-danger">삭제</a>
				</c:if>
				<c:if test="${smssel.mem_no!=mem_no}"> 
				<a class="btn btn-default" href="">구매하기</a>
				</c:if>
			</div> 
			</td>
		</tr>
	</table>
	<h3 class="text-primary">댓글 작성</h3>
		<form name="frm" id="frm">
			<input type="hidden" name="sb_no" value="${smssel.sb_no}">
			<input type="hidden" name="mem_no" value="${mem_no}">
			<table class="table table-hover">
				<!-- 원래는 login한 사람 이름 또는 ID -->
				<tr>
					<td>작성자</td>
					<td>${nickname}</td>
					<td>평점</td>
					<td>
						<select name="re_score">
							<option value="5">5</option>
							<option value="4">4</option>
							<option value="3">3</option>
							<option value="2">2</option>
							<option value="1">1</option>
						</select>
					</td>
					<td>댓글</td>
					<td><textarea rows="3" cols="30" name="re_cont"></textarea></td>
					<td colspan="2"><input type="button" value="댓글입력" id="smsReviewInsert"></td>
				</tr>
			</table>
		</form>
		<div id="rbdListDisp"></div>
		<!-- <div id="boardListDisp"></div> -->
		<!-- zz -->
</div>
</body>
</html>