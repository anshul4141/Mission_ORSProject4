<%@page import="in.co.rays.proj4.util.MessageSource"%>
<%@page import="in.co.rays.proj4.controller.ORSView"%>
<%@page import="in.co.rays.proj4.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Header</title>
</head>

<body>

<%
MessageSource ms = MessageSource.getInstance();
UserBean user = (UserBean) session.getAttribute("user");
String roleName = (String) session.getAttribute("role");
boolean isLogin = user != null;
String welcomeMsg = "Hi, ";
String locale = ms.getLanguage();
%>

	<table>
		<tr style="width: 100%;">

			<td style="width: 98%;">
				<%
				if (isLogin) {
				%>

				<div>
					<h3>
						<b><%=welcomeMsg + user.getFirstName() + "(" + roleName + ")"%></b>
					</h3>

					<a href="<%=ORSView.ROLE_CTL%>"><b>Add Role</b></a> | <a
						href="<%=ORSView.ROLE_LIST_CTL%>"><b>Role List</b></a> | <a
						href="<%=ORSView.USER_CTL%>"><b>Add User</b></a> | <a
						href="<%=ORSView.USER_LIST_CTL%>"><b>User List</b></a> | <a
						href="<%=ORSView.LOGIN_CTL%>?operation=logout"> <b>Logout</b>
					</a>
				</div> 
				
				<%
                }

                if (!isLogin) {
                %>

				<div>
					<h3>Hi, Guest</h3>

					<a href="<%=ORSView.WELCOME_CTL%>"><b>Welcome</b></a> | <a
						href="<%=ORSView.LOGIN_CTL%>"><b>Login</b></a> | <a
						href="<%=ORSView.USER_REGISTRATION_CTL%>"> <b>SignUp</b>
					</a>
				</div> 
                <%
                 }
                %>

			</td>

			<!-- Language Dropdown -->
			<td style="width: 120px; text-align: center;">

				<form style="margin: 0;">
					<select name="lang" onchange="this.form.submit()">
					
						<option value="en" <%=("en".equals(locale)) ? "selected" : ""%>>English</option>
						<option value="hi" <%=("hi".equals(locale)) ? "selected" : ""%>>Hindi</option>

					</select>
				</form>
			</td>
		</tr>
	</table>

	<hr>

</body>
</html>