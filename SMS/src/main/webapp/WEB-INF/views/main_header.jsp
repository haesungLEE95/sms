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
		<nav class="navbar navbar-default" role="navigation">
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<ul class="nav navbar-nav">
					<li><a href="smsSellBoardList.do">홈</a></li>
					<c:forEach var="mcate" items="${mcateList}">
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown"> ${mcate.mcate_name } <b class="caret"></b></a>
							<ul class="dropdown-menu">
								<c:forEach var="scate" items="${scateList}">
									<c:if test="${mcate.mcate_no==scate.mcate_no }">
									<li><a href="#">${scate.scate_name }</a></li>
									</c:if>
								</c:forEach>
							</ul></li>
					</c:forEach>
					<li><a href="list.do">의뢰게시판 </a></li>
					<li><a href="#">신고게시판 </a></li>
				</ul>
			</div>
		</nav>
	</div>
	
</body>
</html>