<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="Header.jsp"%>

	<br>
	<h1 align="Center">
		<font size="10px" color="red">Welcome to ORS<%=isLogin ? "(" + user.getFirstName() + ")" : ""%>
		</font>
	</h1>

	<%@include file="Footer.jsp"%>
</body>
</html>