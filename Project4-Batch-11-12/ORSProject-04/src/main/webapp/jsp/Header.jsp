<%@page import="in.co.rays.proj4.controller.ORSView"%>
<%@page import="in.co.rays.proj4.bean.UserBean"%>
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
	UserBean user = (UserBean) session.getAttribute("user");
	boolean isLogin = user != null;
	String welcomeMsg = "Hii, ";
	%>

	<%
	if (isLogin) {
	%>

	<h2><%=welcomeMsg + user.getFirstName()%></h2>
	<a href="<%=ORSView.ROLE_CTL%>">Add Role</a> |
	<a href="<%=ORSView.ROLE_LIST_CTL%>">Role List</a> |
	<a href="<%=ORSView.USER_CTL%>">Add User</a> |
	<a href="<%=ORSView.USER_LIST_CTL%>">User List</a> |
	<a href="<%=ORSView.LOGIN_CTL + "?operation=logout"%>">Logout</a> |

	<%
	} else {
	%>
	<h2>Hii, Guest</h2>
	<a href="<%=ORSView.LOGIN_CTL%>">Login</a> |
	<a href="<%=ORSView.USER_REGISTRATION_CTL%>">SignUp</a> |
	<%
	}
	%>

	<a href="<%=ORSView.WELCOME_CTL%>">Welcome</a>

	<hr>
</body>
</html>