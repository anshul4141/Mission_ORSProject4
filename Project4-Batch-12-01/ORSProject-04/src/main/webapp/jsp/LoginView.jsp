<%@page import="in.co.rays.proj4.controller.LoginCtl"%>
<%@page import="in.co.rays.proj4.util.ServletUtility"%>
<%@page import="in.co.rays.proj4.controller.BaseCtl"%>
<%@page import="in.co.rays.proj4.controller.ORSView"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="Header.jsp"%>
	<%
	String _suc = ServletUtility.getSuccessMessage(request);
	String _err = ServletUtility.getErrorMessage(request);
	%>

	<form action="<%=ORSView.LOGIN_CTL%>" method="post">

		<div align="center">

			<h1>Login</h1>

			<h3 style="color: green"><%=_suc%></h3>
			<h3 style="color: red"><%=_err%></h3>

			<table>

				<tr>
					<th>Login<font color="red">*</font></th>
					<td><input type="text" name="login" value=""
						placeholder="enter your login"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("login", request)%></td>
				</tr>

				<tr>
					<th>Password<font color="red">*</font></th>
					<td><input type="password" name="password" value=""
						placeholder="enter your password"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("password", request)%></td>
				</tr>

				<tr>
					<th></th>
					<td><input type="submit" name="operation"
						value="<%=LoginCtl.OP_SIGN_IN%>"></td>
				</tr>

			</table>

		</div>

	</form>
	<%@ include file="Footer.jsp"%>
</body>
</html>