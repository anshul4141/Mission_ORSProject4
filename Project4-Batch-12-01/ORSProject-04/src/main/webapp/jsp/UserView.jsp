<%@page import="java.util.HashMap"%>
<%@page import="in.co.rays.proj4.util.DataUtility"%>
<%@page import="in.co.rays.proj4.util.HTMLUtility"%>
<%@page import="in.co.rays.proj4.bean.RoleBean"%>
<%@page import="java.util.List"%>
<%@page import="in.co.rays.proj4.controller.UserCtl"%>
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
	List<RoleBean> roleList = (List) request.getAttribute("roleList");
	HashMap<String, String> map = new HashMap<String, String>();
	map.put("male", "male");
	map.put("female", "female");
	%>

	<jsp:useBean id="bean" class="in.co.rays.proj4.bean.UserBean"
		scope="request"></jsp:useBean>

	<h1 align="center"><%=bean != null && bean.getId() > 0 ? "Update User" : "Add User"%></h1>


	<div align="center">

		<div align="center">

			<%
			if (bean.getId() > 0) {
			%>

			<form action="<%=ORSView.UPLOAD_PHOTO_CTL%>" method="POST"
				enctype="multipart/form-data">

				<input type="hidden" name="id" value="<%=bean.getId()%>">

				<table>

					<tr>
						<th>Photo</th>
					</tr>

					<tr>
						<td align="center"><img
							src="<%=ORSView.UPLOAD_PHOTO_CTL%>?id=<%=bean.getId()%>"
							onerror="this.style.display='none';" alt="User Photo" width="80"
							height="80"
							style="object-fit: cover; border-radius: 50%; border: 1px solid #ccc;">
						</td>
					</tr>

					<tr>
						<td align="center"><input type="file" name="photo"
							accept="image/*"></td>
					</tr>

					<tr>
						<td align="center"><input type="submit" value="Upload Photo">
						</td>
					</tr>

				</table>

			</form>

			<%
			}
			%>

		</div>

	</div>

	<form action="<%=ORSView.USER_CTL%>" method="post">

		<input type="hidden" name="id"
			value="<%=DataUtility.getStringData(bean.getId())%>">

		<div align="center">

			<h3 style="color: green"><%=_suc%></h3>
			<h3 style="color: red"><%=_err%></h3>

			<table>
				<tr>
					<th>FirstName<font color="red">*</font></th>
					<td><input type="text" name="firstName"
						value="<%=DataUtility.getStringData(bean.getFirstName())%>"
						placeholder="enter your firstName"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("firstName", request)%></td>

				</tr>

				<tr>
					<th>LastName<font color="red">*</font></th>
					<td><input type="text" name="lastName"
						value="<%=DataUtility.getStringData(bean.getLastName())%>"
						placeholder="enter your lastName"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("lastName", request)%></td>
				</tr>

				<tr>
					<th>Login<font color="red">*</font></th>
					<td><input type="text" name="login"
						value="<%=DataUtility.getStringData(bean.getLogin())%>"
						placeholder="enter an emial"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("login", request)%></td>

				</tr>

				<tr>
					<th>Password<font color="red">*</font></th>
					<td><input type="password" name="password"
						value="<%=DataUtility.getStringData(bean.getPassword())%>"
						placeholder="enter an password"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("password", request)%></td>
				</tr>

				<tr>

					<th>ConfirmPassword<font color="red">*</font></th>
					<td><input type="password" name="confirmPassword"
						value="<%=DataUtility.getStringData(bean.getPassword())%>"
						placeholder="re-enter your password"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("confirmPassword", request)%></td>
				</tr>

				<tr>
					<th>Role<font color="red">*</font></th>
					<td><%=HTMLUtility.getList("roleId", DataUtility.getStringData(bean.getRoleId()), roleList)%></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("roleId", request)%></td>

				</tr>

				<tr>
					<th>Gender<font color="red">*</font></th>
					<td><%=HTMLUtility.getList("gender", DataUtility.getStringData(bean.getGender()), map)%></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("gender", request)%></td>
				</tr>

				<tr>
					<th>DOB<font color="red">*</font></th>
					<td><input type="date" name="dob"
						value="<%=DataUtility.getStringData(bean.getDob())%>"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("dob", request)%></td>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit" name="operation"
						value="<%=UserCtl.OP_SAVE%>"></td>
				</tr>
			</table>
		</div>
	</form>
	<%@ include file="Footer.jsp"%>
</body>
</html>
