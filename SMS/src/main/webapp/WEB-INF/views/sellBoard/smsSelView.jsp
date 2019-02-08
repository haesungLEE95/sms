<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<!DOCTYPE html><html><head><meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	$(function() {
		$('#boardListDisp').load('smsSellBoardList.do?pageNum=${pageNum}');
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
	function button_buy_event(){
		if (confirm("${smssel.sb_price}원이 차감됩니다") == true){    //확인
			//구매
			location.href="smsQuestBuy.do?sb_no=${smssel.sb_no}&price=${smssel.sb_price}&pageNum=${pageNum}";
		}else{   //취소
		    return;
		}
	}
	function button_chg_event(){
		if (confirm("정말 충전하시겠습니까??") == true){    //확인
			//충전
			location.href="#";
		}else{   //취소
		    return;
		}
	}
	function button_qna_event(){
		if (confirm("문의하시겠습니까??") == true){    //확인
		    location.href="smsQnAInsertForm.do?sb_no=${smssel.sb_no}&pageNum=${pageNum}";
		}else{   //취소
		    return;
		}
	}
</script></head><body>
<div class="container" align="center">
	<h2>게시글 상세내역</h2>
	<table class="table table-hover">
		<tr><td>이미지</td><td><img src="sbimages/${smssel.sb_img }" alt="..."></td></tr>
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
			<c:if test="${smssel.mem_no!=mem_no}"> <!--  작성자가 본인아닐 때 -->
				<%-- <c:if test=""> 로그인 세션에 머니가 충분히 있을 때 --%>
					<input onclick="button_buy_event();" type="button" value="구매하기"
						class="btn btn-primary btn-lg">
				<%-- </c:if> --%>
				<%-- <c:if test=""> 로그인 세션에 머니가 충분히 없을 때 --%>
					<input onclick="button_chg_event();" type="button" value="충전하기"
						class="btn btn-primary btn-lg">
				<%-- </c:if> --%>
				<input onclick="button_qna_event();" type="button" value="문의하기"
					class="btn btn-warning btn-lg">
			</c:if> 
			</div> 
			</td>
		</tr>
	</table>
	<h3 class="text-primary">댓글 작성</h3>
		<form name="frm" id="frm">
			<input type="hidden" name="sb_no" value="${smssel.sb_no}">
			<input type="hidden" name="mem_no" value="1">
			<table class="table table-hover">
				<!-- 원래는 login한 사람 이름 또는 ID -->
				<tr>
					<td>작성자</td>
					<td>로그인정보불러오기</td>
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
		<div id="boardListDisp"></div>
</div>
</body>
</html>