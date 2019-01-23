<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 관리</title>
<script>
	$(document).ready(function() {
		$('.check-all').click(function() {
			$('.ab').prop('checked', this.checked);
		});
	});
</script>
<script type="text/javascript">
	function admindeleteMem() {
		var chk = false;
		for (i = 0; i < frm.checkbox.length; i++) {
			if (frm.checkbox[i].checked) {
				frm.method = "post";
				frm.action = "adminDelMem.do";
				frm.submit();
				chk = true;
			}
		}
		if (chk == false) {
			alert("삭제할 회원을 체크하시오");
		}
	}
</script>
</head>
<body>
	<c:if test="${not empty msg}">
		<script type="text/javascript">
			alert("${msg}");
		</script>
	</c:if>
<div class="container" align="center">
	<form  method="post" name="frm">
	
		<h2 class="text-primary">회원목록</h2>
		<table class="table table-striped">
			<tr>
				<td align="center" width="10%">선택</td>
				<td>회원번호</td>
				<td>회원명</td>
				<td>닉네임</td>
				<td>이메일</td>
				<td>주소</td>
				<td>TEL</td>
				<td>포인트</td>
				<td>가입일</td>
			</tr>
			<c:if test="${empty list}">
				<tr>
					<td colspan="8">데이터가 없습니다</td>
				</tr>
			</c:if>

			<c:forEach items="${list}" var="mem">
				<tr>
					<td align="center"><input type="checkbox" name="checkbox"
						value="${mem.mem_no}" class="ab"></td>
					<td align="center">${mem.mem_no}</td>
					<td>${mem.mem_name}</td>
					<td>${mem.mem_id}</td>
					<td>${mem.nickname}</td>
					<td>${mem.email}</td>
					<td>${mem.tel}</td>
					<td>${mem.mny}</td>
					<td>${mem.mem_reg}</td>
				</tr>
				<tr>
			</c:forEach>
			<tr>
				<td align="center"><label for="allSelect">
					<input type="checkbox" name="all" class="check-all" id="allSelect">전체</label>
				</td>
				<td>
				</td>
				<td align="center">
					<input type="button"	value="탈퇴버튼" onclick="admindeleteMem()">
				</td>
				<td align="center" colspan="6">
					
				</td>
			</tr>
		</table>
	 </form>
	
		<div align="center">
			<ul class="pagination">
				<c:if test="${pb.startPage > pb.pagePerBlock}">
					<li><a
						href="smsMemList.do?pageNum=${pb.startPage - 1}&search=${search}&keyword=${keyword}">
							<span class="glyphicon glyphicon-triangle-left"></span>
					</a></li>
				</c:if>
				<c:forEach var="i" begin="${pb.startPage}" end="${pb.endPage}">
					<c:if test="${pb.currentPage == i}">
						<li class="active"><a
							href="smsMemList.do?pageNum=${i}&search=${search}&keyword=${keyword}">${i}</a>
						</li>
					</c:if>
					<c:if test="${pb.currentPage != i}">
						<li><a
							href="smsMemList.do?pageNum=${i}&search=${search}&keyword=${keyword}">${i}</a></li>
					</c:if>
				</c:forEach>
				<c:if test="${pb.endPage < pb.totalPage}">
					<li><a
						href="smsMemList.do?pageNum=${pb.endPage + 1}&search=${search}&keyword=${keyword}">
							<span class="glyphicon glyphicon-triangle-right"></span>
					</a></li>
				</c:if>
			</ul>
			<form action="smsMemList.do">
				<select name="search">
					<c:forTokens var="sh" items="mem_name,nickname,namenick" delims=","
						varStatus="i">
						<c:if test="${sh==mem.search}">
							<option value="${sh}" selected="selected">
								${ops[i.index]}</option>
						</c:if>
						<c:if test="${sh!=mem.search}">
							<option value="${sh}">${ops[i.index]}</option>
						</c:if>
					</c:forTokens>
				</select> <input type="text" name="keyword"> <input type="submit"
					value="확인">
			</form>
		</div>

		<a class="btn btn-info" href="adminMain.do">메인으로</a>
	</div>
</body>
</html>