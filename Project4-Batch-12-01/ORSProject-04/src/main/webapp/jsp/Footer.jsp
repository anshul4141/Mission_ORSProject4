<!DOCTYPE html>
<%@page import="in.co.rays.proj4.util.MessageSource"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
#footer {
	position: fixed;
	left: 0;
	width: 100%;
	bottom: 0;
	background-color: white;
	color: black;
	text-align: center;
}
</style>

</head>
<body>
	<div id="footer">
		<hr>
		<h3><%=MessageSource.getInstance().get("footer.title")%></h3>
	</div>
</body>
</html>