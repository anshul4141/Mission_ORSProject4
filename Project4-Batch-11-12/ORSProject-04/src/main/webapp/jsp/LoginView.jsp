<!DOCTYPE html>
<%@page import="in.co.rays.proj4.controller.LoginCtl"%>
<%@page import="in.co.rays.proj4.util.ServletUtility"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="Header.jsp"%>

	<div align="center">

		<h1>Login</h1>

		<form action="<%=ORSView.LOGIN_CTL%>" method="post">

			<table>

				<tr>
					<th>Login</th>
					<td><input type="text" name="login"
						placeholder="enter you login" value=""></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("login", request)%></td>
				</tr>

				<tr>
					<th>Password</th>
					<td><input type="password" name="password"
						placeholder="enter you password" value=""></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("password", request)%></td>
				</tr>

				<tr>
					<th></th>
					<td><input type="submit" name="operation"
						value="<%=LoginCtl.OP_SIGN_IN%>"></td>
				</tr>

			</table>

		</form>

	</div>

	<%@include file="Footer.jsp"%>
</body>
</html>