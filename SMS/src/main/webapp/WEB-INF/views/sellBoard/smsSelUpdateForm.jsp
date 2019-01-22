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
		<form action="smsSellBoardUpdate.do" method="post">
			<input type="hidden" name="mcate_no" value="${smssel.mcate_no }">
			<input type="hidden" name="scate_no" value="${smssel.scate_no }">
			<input type="hidden" name="mem_no" value="${smssel.mem_no}">
			<input type="hidden" name="sb_no" value="${smssel.sb_no}">
			<input type="hidden" name="sb_img" value="${smssel.sb_img}">
			
			<input type="hidden" name="pageNum" value="${pageNum}">
			<table class="table table-hover">
				<tr>
					<td>카테고리</td>
					<td><c:forEach var="mcate" items="${mcateList }">
							<c:if test="${mcate.mcate_no==smssel.mcate_no }">
								<span class="label label-info">${mcate.mcate_name }</span>
							</c:if>
						</c:forEach> <c:forEach var="scate" items="${scateList }">
							<c:if test="${scate.scate_no==smssel.scate_no }">
								<span class="label label-info">${scate.scate_name }</span>
							</c:if>
						</c:forEach></td>
				</tr>
				<tr>
					<td>제목</td>
					<td><input type="text" name="sb_title" required="required"
						autofocus="autofocus" value="${smssel.sb_title}"></td>
				</tr>
				<tr>
					<td>희망가격</td>
					<td><input type="number" name="sb_price" required="required"
						value="${smssel.sb_price}"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><pre><textarea rows="5" cols="40" name="sb_desc" required="required">${smssel.sb_desc}</textarea></pre>
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