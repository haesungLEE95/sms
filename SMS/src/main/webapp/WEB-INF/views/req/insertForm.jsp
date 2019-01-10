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
		<h2>게시글 입력</h2>
		<form action="insert.do" method="post">
			<table class="table table-hover">
				<tr>
					<td>제목</td>
					<td><input type="text" name="subject" required="required"
						autofocus="autofocus"></td>
				</tr>
				<tr>
					<td>카테고리</td>
					<td>
					<div class="btn-group">
						<select >
							<c:forEach var="mcate" items="${mcateList}">
								<option>${mcate.mcate_name }</option>
							</c:forEach>
						</select>
						<select>
							<c:forEach var="scate" items="${scateList}">
								<c:if test="${mcate.mcate_no==scate.mcate_no }">
									<option>${scate.scate_name }</option>
								</c:if>
							</c:forEach>
						</select>
<%-- 						<button type="button" class="btn btn-default btn-sm btn-primary dropdown-toggle"
							data-toggle="dropdown">
							<span class="caret"></span>
						</button>
						<ul class="dropdown-menu" role="menu">
							<c:forEach var="mcate" items="${mcateList}">
								<li class="dropdown-header">${mcate.mcate_name }</li>
								<li class="divider"></li>
								<c:forEach var="scate" items="${scateList}">
									<c:if test="${mcate.mcate_no==scate.mcate_no }">
										<li>${scate.scate_name }</li>
									</c:if>
								</c:forEach>
								<li class="divider"></li>
							</c:forEach>
						</ul>
 --%>					</div>
					</td>
				</tr>
				<tr>
					<td>작성자</td>
					<td><input type="text" name="writer" required="required"></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="email" name="email" required="required"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea rows="5" cols="40" name="content"
							required="required"></textarea></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="확인"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>