<%@page import="com.sunilos.p4.util.DataUtility"%>
<%@page import="com.sunilos.p4.util.ServletUtility"%>
<%@page import="com.sunilos.p4.ctl.ORSView"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<jsp:useBean id="bean" class="com.sunilos.p4.bean.RoleBean"
		scope="request"></jsp:useBean>

	<%
	String _suc = ServletUtility.getSuccessMessage(request);
	String _err = ServletUtility.getErrorMessage(request);
	%>

	<div align="center">
		<h1><%=bean != null && bean.getId() > 0 ? "Edit Role" : "Add Role"%></h1>



		<form action="<%=ORSView.ROLE_CTL%>" method="post">

			<input type="text" name="id"
				value="<%=bean != null ? bean.getId() : ""%>">
			<%--  <input type="hidden" name="createdBy" value="<%=bean.getCreatedBy()%>">
            <input type="hidden" name="modifiedBy" value="<%=bean.getModifiedBy()%>"> 
            <input type="hidden" name="createdDatetime" value="<%=DataUtility.getTimestamp(bean.getCreatedDatetime())%>">
            <input type="hidden" name="modifiedDatetime" value="<%=DataUtility.getTimestamp(bean.getModifiedDatetime())%>"> --%>

			<font color="green"><%=_suc != null ? _suc : ""%></font> <font
				color="red"><%=_err != null ? _err : ""%></font>

			<table>
				<tr>
					<th>Role Name:</th>
					<td><input type="text" name="name"
						value="<%=DataUtility.getStringData(bean.getName())%>"
						placeholder="enter role name"></td>
					<td style="color: red"><%=request.getAttribute("name") != null ? request.getAttribute("name") : ""%></td>
				</tr>
				<tr>
					<th>Description:</th>
					<td><input type="text" name="description"
						value="<%=DataUtility.getStringData(bean.getDescription())%>"
						placeholder="enter role description"></td>
					<td style="color: red"><%=request.getAttribute("description") != null ? request.getAttribute("description") : ""%></td>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit" name="operation"
						value="<%=bean != null && bean.getId() > 0 ? "Update" : "Save"%>"></td>

				</tr>
			</table>

		</form>

	</div>
</body>
</html>