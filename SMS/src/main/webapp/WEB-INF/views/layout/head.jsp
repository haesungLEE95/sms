<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">

 .first {
	position: relative;
	top: 0px;
	left: 0px;
	z-index: 2;
} 
.second {
	z-index: 1;
}

</style>

<script type="text/javascript">
	$("#btnLogin").click(function(event) {

		var form = $("#formLogin")

		if (form[0].checkValidity() === false) {
			event.preventDefault()
			event.stopPropagation()
		}

		form.addClass('was-validated');
	});
</script>

</head>
<body>

	<div class="container">

		<div class="row">

			<div class="col-12 text-left py-2">
				<div class="first">
					<a href="smsSellBoardList.do"><img src="images/SMS.png"
						height="80"></a> 
				</div>
					
				<div class="second" align="right">
								
				<c:choose>
					<c:when test="${not empty nickname}">
						<font color="green"><c:out value="${nickname}" />님 환영합니다　 </font> 
						<c:choose>
							<c:when test="${admin_id == 'admin' }">
								<a href="adminMain.do">관리자 페이지</a>
							</c:when>
							<c:when test="${admin_id != 'admin' }">
								<a href="myPage.do" class="btn btn-info">마이페이지</a>
							</c:when>
						</c:choose>
					</c:when>
				</c:choose>
								
				<c:choose>
				<c:when test="${not empty nickname}">
					<a href="logout.do" class="btn btn-danger">로그아웃</a>		
				</c:when>
				<c:when test="${empty nickname}">
					<a href="joinForm.do" class="btn btn-info">회원가입</a>
					<a href="#loginModal" role="button" class="btn btn-primary" data-toggle="modal">로그인</a>
				</c:when>
			</c:choose>
					
				<!-- 	<a href="joinForm.do" class="btn btn-info">회원가입</a>
					<a href="#loginModal" role="button" class="btn btn-primary" data-toggle="modal">로그인</a> -->
					
				</div>
				
		</div>
		<!-- Search form -->
		<form class="navbar-form navbar-right" action="smsSellBoardList.do">
			<br> <input type="text" class="form-control" name="keyword">
			<button type="submit" class="btn btn-default">검색</button>
		</form>
	</div>



	<div id="loginModal" class="modal fade" tabindex="-1" role="dialog"
		aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h3>Login</h3>
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
				</div>
				<div class="modal-body">
					<form class="form" action="login.do" role="form" autocomplete="off" id="formLogin"
						novalidate="" method="POST">
						<div class="form-group">
							<a href="" class="float-right"></a> <label for="mem_id">아이디</label>
							<input type="text" class="form-control form-control-lg"
								name="mem_id" id="mem_id" required="">
							<div class="invalid-feedback"></div>
						</div>
						<div class="form-group">
							<label>비밀번호</label> <input type="password"
								class="form-control form-control-lg" name="passwd" id="passwd" required=""
								autocomplete="new-password">
							<div class="invalid-feedback"></div>
						</div>
						<div class="custom-control custom-checkbox">
							<input type="checkbox" class="custom-control-input"
								id="rememberMe"> <label class="custom-control-label"
								for="rememberMe">Remember me on this computer</label>
						</div>
						<div class="form-group py-4">
							<button type="submit" class="btn btn-success btn-lg"
								id="btnLogin">로그인</button>
							<button class="btn btn-outline-secondary btn-lg float-center"
								data-dismiss="modal" aria-hidden="true">취소</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>



	<div class="container">
		<nav class="navbar navbar-default" role="navigation">
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<ul class="nav navbar-nav">
					<li><a href="smsSellBoardList.do">홈</a></li>
					<c:forEach var="mcate" items="${mcateList}">
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown"> ${mcate.mcate_name } <b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href="smsSellBoardList.do?mno=${mcate.mcate_no }">${mcate.mcate_name }
										전체</a></li>
								<c:forEach var="scate" items="${scateList}">
									<c:if test="${mcate.mcate_no==scate.mcate_no }">
										<li><a
											href="smsSellBoardList.do?mno=${scate.mcate_no }&sno=${scate.scate_no }">${scate.scate_name }</a></li>
									</c:if>
								</c:forEach>
							</ul></li>
					</c:forEach>
					<li><a href="list.do">의뢰게시판 </a></li>
					<li><a href="smsChaList.do">신고게시판 </a></li>
					<c:if test="${not empty nickname }">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown"> 마이페이지 <b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href="smsBuyQuestList.do">구매내역</a></li>
								<li><a href="smsSelQuestList.do">판매내역 </a></li>
								<li><a href="smsQnAList.do">거래문의</a></li>
							</ul>
					</li>
					</c:if>
				</ul>
			</div>
		</nav>
	</div>
	</div>
</body>
</html>