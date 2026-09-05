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
	UserBean userBean = (UserBean) session.getAttribute("user");
	String roleName = (String) session.getAttribute("role");
	boolean isLogin = userBean != null;
	String welcomeMsg = "Hi, ";
	%>

	<table>
		<tr style="width: 100%;">
			<td style="width: 98%;">
				<%
				if (isLogin) {
				%>
				<div>
					<h3><b><%=welcomeMsg + userBean.getFirstName() + "(" + roleName + ")"%></b></h3>
					<a href="<%=ORSView.ROLE_CTL%>"><b>Add Role</b></a> | 
					<a href="<%=ORSView.ROLE_LIST_CTL%>"><b>Role List</b></a> | 
					<a href="LoginCtl?operation=logout"><b>Logout</b> </a>
				</div> <%
                }
                %> 
 
                <%
                if (!isLogin) {
                %>
				<div>
					<h3>Hi, Guest</h3>
					<a href="#"><b>Welcome</b></a> | 
					<a href="#"><b>Login</b></a> |
					<a href="#"><b>SignUp</b></a>
				</div> 
				<%
                }
                %>
			</td>
			<td style="width: 2%;">
				<div>
					<img src="<%=ORSView.APP_CONTEXT%>/img/customLogo.jpg" width="175"
						height="50">
				</div>
			</td>
		</tr>
	</table>
	<hr>

</body>
</html>