<%@page import="com.sunilos.p4.ctl.BaseCtl"%>
<%@page import="com.sunilos.p4.util.DataUtility"%>
<%@page import="com.sunilos.p4.ctl.ORSView"%>
<%@page import="com.sunilos.p4.util.ServletUtility"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="Header.jsp"%>
	<jsp:useBean id="bean" class="com.sunilos.p4.bean.UserBean"
		scope="request"></jsp:useBean>

	<%
	String _suc = ServletUtility.getSuccessMessage(request);
	String _err = ServletUtility.getErrorMessage(request);
	%>

	<div align="center">
		<h1>User Registration</h1>



		<form action="<%=ORSView.USER_REGISTRATION_CTL%>" method="post">

			<%-- <input type="text" name="id"
				value="<%=bean != null ? bean.getId() : ""%>"> --%>
			<%--  <input type="hidden" name="createdBy" value="<%=bean.getCreatedBy()%>">
            <input type="hidden" name="modifiedBy" value="<%=bean.getModifiedBy()%>"> 
            <input type="hidden" name="createdDatetime" value="<%=DataUtility.getTimestamp(bean.getCreatedDatetime())%>">
            <input type="hidden" name="modifiedDatetime" value="<%=DataUtility.getTimestamp(bean.getModifiedDatetime())%>"> --%>

			<font color="green"><%=_suc != null ? _suc : ""%></font> <font
				color="red"><%=_err != null ? _err : ""%></font>

			<table>
				<tr>
					<th>First Name:</th>
					<td><input type="text" name="firstName"
						value="<%=DataUtility.getStringData(bean.getFirstName())%>"
						placeholder="enter firstName"></td>
					<td style="color: red"><%=request.getAttribute("firstName") != null ? request.getAttribute("firstName") : ""%></td>
				</tr>
				<tr>
					<th>Last Name:</th>
					<td><input type="text" name="lastName"
						value="<%=DataUtility.getStringData(bean.getLastName())%>"
						placeholder="enter lastName"></td>
					<td style="color: red"><%=request.getAttribute("lastName") != null ? request.getAttribute("lastName") : ""%></td>
				</tr>
				<tr>
					<th>Login:</th>
					<td><input type="email" name="login"
						value="<%=DataUtility.getStringData(bean.getLogin())%>"
						placeholder="enter email"></td>
					<td style="color: red"><%=request.getAttribute("login") != null ? request.getAttribute("login") : ""%></td>
				</tr>
				<tr>
					<th>Password:</th>
					<td><input type="password" name="password"
						value="<%=DataUtility.getStringData(bean.getPassword())%>"
						placeholder="enter password"></td>
					<td style="color: red"><%=request.getAttribute("password") != null ? request.getAttribute("password") : ""%></td>
				</tr>
				<tr>
					<th>Confirm Password:</th>
					<td><input type="password" name="confirmPassword"
						value="<%=DataUtility.getStringData(bean.getPassword())%>"
						placeholder="enter confirmPassword"></td>
					<td style="color: red"><%=request.getAttribute("confirmPassword") != null ? request.getAttribute("confirmPassword") : ""%></td>
				</tr>
				<tr>
					<th>Gender:</th>
					<td><input type="text" name="gender"
						value="<%=DataUtility.getStringData(bean.getGender())%>"
						placeholder="enter gender"></td>
					<td style="color: red"><%=request.getAttribute("gender") != null ? request.getAttribute("gender") : ""%></td>
				</tr>
				<tr>
					<th>Dob:</th>
					<td><input type="date" name="dob"
						value="<%=DataUtility.getStringData(bean.getDob())%>"></td>
					<td style="color: red"><%=request.getAttribute("dob") != null ? request.getAttribute("dob") : ""%></td>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit" name="operation" value="SignUp""></td>

				</tr>
			</table>

		</form>

	</div>
</body>
</html>