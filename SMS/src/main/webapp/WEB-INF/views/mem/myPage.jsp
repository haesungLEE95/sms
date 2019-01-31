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
/* 	$(document).ready(function() {
		// test_btn 버튼의 쿠키값을 검사한다. -  값이 Y 인경우 testDiv 부분 open
		if ($.cookie("utd_btn") == "Y") {
			$("#dispUpdate").show();
			$("#update");
			//버튼이미지 변경
		} else {
			$("#dispUpdate").hide();
			$("#update");
		}
	});
 */
 </script>
 <script type="text/javascript">
 function chargeMny() {
		window.open("chargeMny.do?mem_no=${mem.mem_no}", "포인트 충전", "width=530, height=380, left=100, top=50"); 
		}
 var profImg 
</script>
<style type="text/css">
.prof {
	width: 350px
}

#pimg {
	width: 100px;
	height: 100px;
	object-fit: cover;
}

.btn btn-info {
	width: 140px;
	align-content: center;
}

.btn btn-success{
	width: 160px;
	align-content: center;
}
</style>
</head>
<body>
	<div class="container" align="center">
		<table class="table table-striped">
			<tr>
				<th class="prof" rowspan="2">
					<c:if test="${ !empty mem.mem_img }">
						<img id="pimg" width="100px" height="100px"
							src="upload/${mem.mem_img}">
					</c:if>	${mem.nickname }님<br>환영합니다<br>
					<div id="disp"></div></th>
				<td>내 포인트 : ${mem.mny }</td>
			</tr>
			<tr>
				<td>내 게시글(?)</td>
			</tr>
			<tr>
				<th><a href="updateInfo.do?mem_id=${mem.mem_id }" class="btn btn-info">개인정보 수정</a><br><br>
				<input type="button" value="포인트 충전" onclick="chargeMny();" class="btn btn-success"></th>
				<td>내용</td>
			</tr>
		</table>

	</div>
	<a href="logout.do">로그아웃</a>
</body>
</html>