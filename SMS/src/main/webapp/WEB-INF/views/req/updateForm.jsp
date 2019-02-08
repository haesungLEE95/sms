<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h2>게시글 수정</h2>
		<form action="update.do" method="post">
			<input type="hidden" name="mcate_no" value="${smsReq.mcate_no }">
			<input type="hidden" name="scate_no" value="${smsReq.scate_no }">
			<input type="hidden" name="mem_no" value="${smsReq.mem_no}">
			<input type="hidden" name="rq_no" value="${smsReq.rq_no}">
			
			<input type="hidden" name="pageNum" value="${pageNum}">
			<table class="table table-hover">
				<tr>
					<td>카테고리</td>
					<td><c:forEach var="mcate" items="${mcateList }">
							<c:if test="${mcate.mcate_no==smsReq.mcate_no }">
								<span class="label label-info">${mcate.mcate_name }</span>
							</c:if>
						</c:forEach> <c:forEach var="scate" items="${scateList }">
							<c:if test="${scate.scate_no==smsReq.scate_no }">
								<span class="label label-info">${scate.scate_name }</span>
							</c:if>
						</c:forEach></td>
				</tr>
				<tr>
					<td>제목</td>
					<td><input type="text" name="rq_title" required="required"
						autofocus="autofocus" value="${smsReq.rq_title}"></td>
				</tr>
				<tr>
					<td>희망가격</td>
					<td><input type="number" name="rq_price" required="required"
						value="${smsReq.rq_price}"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><pre><textarea rows="5" cols="40" name="rq_cont" required="required">${smsReq.rq_cont}</textarea></pre>
					</td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="확인"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>