<%@page import="in.co.rays.proj4.controller.UserRegistrationCtl"%>
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

	<form action="<%=ORSView.USER_CTL%>" method="post">

		<div align="center">

			<h1>Add User</h1>

			<h3 style="color: green"><%=_suc%></h3>
			<h3 style="color: red"><%=_err%></h3>

			<table>

				<tr>
					<th>FirstName<font color="red">*</font></th>
					<td><input type="text" name="firstName" value=""
						placeholder="enter your firstName"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("firstName", request)%></td>
				</tr>

				<tr>
					<th>LastName<font color="red">*</font></th>
					<td><input type="text" name="lastName" value=""
						placeholder="enter your lastName"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("lastName", request)%></td>
				</tr>

				<tr>
					<th>Login<font color="red">*</font></th>
					<td><input type="text" name="login" value=""
						placeholder="enter an emial"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("login", request)%></td>
				</tr>

				<tr>
					<th>Password<font color="red">*</font></th>
					<td><input type="password" name="password" value=""
						placeholder="enter an password"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("password", request)%></td>
				</tr>

				<tr>
					<th>ConfirmPassword<font color="red">*</font></th>
					<td><input type="password" name="confirmPassword" value=""
						placeholder="re-enter your password"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("confirmPassword", request)%></td>
				</tr>

				<tr>
					<th>Role<font color="red">*</font></th>
					<td><select class='form-control' name='roleId'>
							<option selected value=''>-------------Select------------</option>
							<option value='1'>Admin</option>
							<option value='2'>Student</option>
							<option value='3'>College</option>
							<option value='4'>KIOSK</option>
					</select></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("roleId", request)%></td>
				</tr>

				<tr>
					<th>Gender<font color="red">*</font></th>
					<td><select class='form-control' name='gender'>
							<option selected value=''>-------------Select------------</option>
							<option value='female'>female</option>
							<option value='male'>male</option>
					</select></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("gender", request)%></td>
				</tr>

				<tr>
					<th>DOB<font color="red">*</font></th>
					<td><input type="date" name="dob" value=""></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("dob", request)%></td>
				</tr>

				<tr>
					<th></th>
					<td><input type="submit" name="operation"
						value="<%=UserRegistrationCtl.OP_SIGN_UP%>"></td>
				</tr>

			</table>

		</div>

	</form>
	<%@ include file="Footer.jsp"%>
</body>
</html>