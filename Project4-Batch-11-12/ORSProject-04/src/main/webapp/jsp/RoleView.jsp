<!DOCTYPE html>
<%@page import="in.co.rays.proj4.controller.RoleCtl"%>
<%@page import="in.co.rays.proj4.controller.LoginCtl"%>
<%@page import="in.co.rays.proj4.util.ServletUtility"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	String succ = ServletUtility.getSuccessMessage(request);
	String error = ServletUtility.getErrorMessage(request);
	%>

	<%@ include file="Header.jsp"%>

	<div align="center">

		<h1>Add Role</h1>

		<h3 style="color: green"><%=succ%></h3>
		<h3 style="color: red"><%=error%></h3>

		<form action="<%=ORSView.ROLE_CTL%>" method="post">

			<table>

				<tr>
					<th>Name</th>
					<td><input type="text" name="name"
						placeholder="enter role name" value=""></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("name", request)%></td>
				</tr>

				<tr>
					<th>description</th>
					<td><input type="text" name="description"
						placeholder="enter description" value=""></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("description", request)%></td>
				</tr>

				<tr>
					<th></th>
					<td><input type="submit" name="operation"
						value="<%=RoleCtl.OP_SAVE%>"></td>
				</tr>

			</table>

		</form>

	</div>

	<%@include file="Footer.jsp"%>
</body>
</html>