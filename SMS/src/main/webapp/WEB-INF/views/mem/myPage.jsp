<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<script type="text/javascript">
	$(function() {
		$('#disp').load('profile.do?mem_id=${mem.mem_id}');
	});
</script>
<style type="text/css">
.prof {width: 350px }
</style>
</head>
<body>
<div class="container" align="center">
	<table class="table table-striped">
	<tr><th class="prof" rowspan="2">
	${mem.mem_id }님 환영합니다<br>
	<div id="disp"></div>
	</th><td>상단 통계 영역</td></tr>
	<tr><td>내 게시글(?)</td></tr>
	<tr><th>프로필 영역</th><td>내용</td></tr>
	</table>
</div>
</body>
</html>