<%@page import="com.sunilos.p4.ctl.ORSView"%>
<%@page import="com.sunilos.p4.bean.UserBean"%>
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
	UserBean userBean = (UserBean) session.getAttribute("user");
	%>

	<%
	if (userBean != null) {
	%>
	<h3><%="Hii, " + userBean.getFirstName() + ("(" + session.getAttribute("role") + ")")%></h3>
	<a href="<%=ORSView.ROLE_CTL%>">Add Role</a> |
	<a href="<%=ORSView.ROLE_LIST_CTL%>">Role List</a> |
	<a href="<%=ORSView.LOGIN_CTL%>?operation=logout">Logout</a> |
	<%
	} else {
	%>
	<h3>Hi, Guest</h3>
	<a href="<%=ORSView.LOGIN_CTL%>">Login</a> |
	<a href="<%=ORSView.USER_REGISTRATION_CTL%>">SignUp</a> |
	<%
	}
	%>

	<a href="WelcomeCtl">Welcome</a>

	<hr>

</body>
</html>