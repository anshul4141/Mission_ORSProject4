<%@page import="com.sunilos.p4.util.ServletUtility"%>
<%@page import="com.sunilos.p4.ctl.ORSView"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	String _suc = ServletUtility.getSuccessMessage(request);
	String _err = ServletUtility.getErrorMessage(request);
	%>

	<div align="center">
		<h1>Role View</h1>

		<form action="<%=ORSView.ROLE_CTL%>" method="post">

			<font color="green"><%=_suc != null ? _suc : ""%></font>
			<font color="red"><%=_err != null ? _err : ""%></font>

			<table>
				<tr>
					<th>Role Name:</th>
					<td><input type="text" name="name" value=""
						placeholder="enter role name"></td>
					<td style="color: red"><%=request.getAttribute("name") != null ? request.getAttribute("name") : ""%></td>
				</tr>
				<tr>
					<th>Description:</th>
					<td><input type="text" name="description" value=""
						placeholder="enter role description"></td>
					<td style="color: red"><%=request.getAttribute("description") != null ? request.getAttribute("description") : ""%></td>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit" name="operation" value="save"></td>

				</tr>
			</table>

		</form>

	</div>
</body>
</html>