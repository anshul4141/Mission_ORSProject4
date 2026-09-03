<%@page import="in.co.rays.proj4.util.ServletUtility"%>
<%@page import="in.co.rays.proj4.controller.BaseCtl"%>
<%@page import="in.co.rays.proj4.controller.ORSView"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
	String _suc = ServletUtility.getSuccessMessage(request);
	String _err = ServletUtility.getErrorMessage(request);
	%>

	<form action="<%=ORSView.ROLE_CTL%>" method="post">

		<div align="center">

			<h1>Add Role</h1>

			<h3 style="color: green"><%=_suc != null ? _suc : ""%></h3>
			<h3 style="color: red"><%=_err != null ? _err : ""%></h3>

			<table>

				<tr>
					<th>Name<font color="red">*</font></th>
					<td><input type="text" name="name" value=""
						placeholder="enter role name"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("name", request)%></td>
				</tr>

				<tr>
					<th>Description<font color="red">*</font></th>
					<td><input type="text" name="description" value=""
						placeholder="enter role description"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("description", request)%></td>
				</tr>

				<tr>
					<th></th>
					<td><input type="submit" name="operation"
						value="<%=BaseCtl.OP_SAVE%>"></td>
				</tr>

			</table>

		</div>

	</form>
</body>
</html>