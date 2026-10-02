<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%@ include file="Header.jsp"%>

	<form action="<%=ORSView.USER_REGISTRATION_CTL%>" method="post">

		<div align="center">

			<h1>Registration</h1>

			<table>

				<tr>
					<th>FirstName<font color="red">*</font></th>
					<td><input type="text" name="firstName" value=""
						placeholder="enter your firstName"></td>
				</tr>

				<tr>
					<th>LastName<font color="red">*</font></th>
					<td><input type="text" name="lastName" value=""
						placeholder="enter your lastName"></td>
				</tr>

				<tr>
					<th>Login<font color="red">*</font></th>
					<td><input type="text" name="login" value=""
						placeholder="enter an emial"></td>
				</tr>

				<tr>
					<th>Password<font color="red">*</font></th>
					<td><input type="password" name="password" value=""
						placeholder="enter an password"></td>
				</tr>

				<tr>
					<th>ConfirmPassword<font color="red">*</font></th>
					<td><input type="password" name="confirmPassword" value=""
						placeholder="re-enter your password"></td>
				</tr>

				<tr>
					<th>Gender<font color="red">*</font></th>
					<td><select name='gender'>
							<option selected value=''>------------Select-------------</option>
							<option value='female'>female</option>
							<option value='male'>male</option>
					</select></td>
				</tr>

				<tr>
					<th>DOB<font color="red">*</font></th>
					<td><input type="date" name="dob" value=""></td>
				</tr>

				<tr>
					<th></th>
					<td><input type="submit" name="operation" value="SignUp"></td>
				</tr>

			</table>

		</div>

	</form>
	<%@ include file="Footer.jsp"%>
</body>
</html>