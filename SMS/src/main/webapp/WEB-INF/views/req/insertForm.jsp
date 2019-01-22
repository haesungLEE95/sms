<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script type="text/javascript">
		function chmcate(){
			var pickmcate=$('#pickmcate').val();
			var f = document.forms.frm;
			if (pickmcate == 1) { f.scate1.style.display = ""; f.scate2.style.display = "none"; f.scate3.style.display = "none"; f.scate4.style.display = "none"; f.scate5.style.display = "none"; f.scate6.style.display = "none"; f.scate7.style.display = "none"; }
			else if (pickmcate == 2) { f.scate1.style.display = "none"; f.scate2.style.display = ""; f.scate3.style.display = "none"; f.scate4.style.display = "none"; f.scate5.style.display = "none"; f.scate6.style.display = "none"; f.scate7.style.display = "none"; }
			else if (pickmcate == 3) { f.scate1.style.display = "none"; f.scate2.style.display = "none"; f.scate3.style.display = ""; f.scate4.style.display = "none"; f.scate5.style.display = "none"; f.scate6.style.display = "none"; f.scate7.style.display = "none"; }
			else if (pickmcate == 4) { f.scate1.style.display = "none"; f.scate2.style.display = "none"; f.scate3.style.display = "none"; f.scate4.style.display = ""; f.scate5.style.display = "none"; f.scate6.style.display = "none"; f.scate7.style.display = "none"; }
			else if (pickmcate == 5) { f.scate1.style.display = "none"; f.scate2.style.display = "none"; f.scate3.style.display = "none"; f.scate4.style.display = "none"; f.scate5.style.display = ""; f.scate6.style.display = "none"; f.scate7.style.display = "none"; }
			else if (pickmcate == 6) { f.scate1.style.display = "none"; f.scate2.style.display = "none"; f.scate3.style.display = "none"; f.scate4.style.display = "none"; f.scate5.style.display = "none"; f.scate6.style.display = ""; f.scate7.style.display = "none"; }
			else if (pickmcate == 7) { f.scate1.style.display = "none"; f.scate2.style.display = "none"; f.scate3.style.display = "none"; f.scate4.style.display = "none"; f.scate5.style.display = "none"; f.scate6.style.display = "none"; f.scate7.style.display = ""; }
			/* $.post('chmcate.do',"pickmcate="+pickmcate, function(data) {
				alert(data);
				for(var i=0;i<data.size();i++) {
					document.fo.scate.options[i] = data.scate_name;
					document.fo.scate.options[i].value = data.scate_no;
				}
				frm.a.value=data;
			}); */
		}
		function setcate() {
			frm.mcate_no.value=frm.pickmcate.value;
			if(frm.pickmcate.value==1)
				frm.scate_no.value=frm.scate1.value;
			if(frm.pickmcate.value==2)
				frm.scate_no.value=frm.scate2.value;
			if(frm.pickmcate.value==3)
				frm.scate_no.value=frm.scate3.value;
			if(frm.pickmcate.value==4)
				frm.scate_no.value=frm.scate4.value;
			if(frm.pickmcate.value==5)
				frm.scate_no.value=frm.scate5.value;
			if(frm.pickmcate.value==6)
				frm.scate_no.value=frm.scate6.value;
			if(frm.pickmcate.value==7)
				frm.scate_no.value=frm.scate7.value;
		}
	</script>
</head>
<body>

	<div class="container">
		<h2>게시글 입력</h2>
		<form action="insert.do" method="post" name="frm" onsubmit="setcate()">
		<input type="hidden" name="mcate_no">
		<input type="hidden" name="scate_no">
			<table class="table table-hover">
				<tr>
					<td>카테고리</td>
					<td>
					<div class="btn-group">
						<select id="pickmcate" name="pickmcate" onchange="chmcate()">
							<c:forEach var="mcate" items="${mcateList}">
								<option value="${mcate.mcate_no }">${mcate.mcate_name }</option>
							</c:forEach>
						</select>
						<c:forEach var="mcate" items="${mcateList}">
							<c:if test="${mcate.mcate_no==1 }">
								<select name="scate${mcate.mcate_no }" style="display: ;">
							</c:if>
							<c:if test="${mcate.mcate_no!=1 }">
								<select name="scate${mcate.mcate_no }" style="display: none;">
							</c:if>
	 							<c:forEach var="scate" items="${scateList}">
	 								<c:if test="${mcate.mcate_no==scate.mcate_no }">
										<option value="${scate.scate_no }">${scate.scate_name }</option>
									</c:if>
								</c:forEach>
	 						</select>
						</c:forEach>
					</div>
					</td>
				</tr>
				<tr>
					<td>제목</td>
					<td><input type="text" name="rq_title" required="required"
						autofocus="autofocus"></td>
				</tr>
				<tr>
					<td>희망가격</td>
					<td><input type="number" name="rq_price" required="required"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea rows="5" cols="40" name="rq_cont"
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