<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ include file="../header.jsp"%>
<!DOCTYPE html><html><head><meta charset="UTF-8">
<title><tiles:insertAttribute name="title"/></title>
</head><body>
<div class="container" align="center">
<table class="table table-bordered" border="1" >
	<tr><td height="50" colspan="2">
			<tiles:insertAttribute name="head"/></td></tr>
	<tr>
		<td>	
			<tiles:insertAttribute name="body"/>
		</td>
	</tr>
	<tr><td height="20" colspan="2">
			<tiles:insertAttribute name="footer"/></td></tr>
</table></div>
</body>
</html>