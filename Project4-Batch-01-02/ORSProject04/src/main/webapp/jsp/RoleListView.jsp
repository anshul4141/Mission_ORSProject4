<%@page import="com.sunilos.p4.ctl.BaseCtl"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.sunilos.p4.util.ServletUtility"%>
<%@page import="com.sunilos.p4.bean.RoleBean"%>
<%@page import="java.util.List"%>
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

	<%
	String _suc = ServletUtility.getSuccessMessage(request);
	String _err = ServletUtility.getErrorMessage(request);
	List<RoleBean> list = ServletUtility.getList(request);
	List nextList = (List) request.getAttribute("nextList");
	int pageNo = ServletUtility.getPageNo(request);
	int pageSize = ServletUtility.getPageSize(request);

	Iterator<RoleBean> it = list.iterator();
	%>

	<div align="center">
		<h1>Role List</h1>
		<form action="<%=ORSView.ROLE_LIST_CTL%>" method="post">

			<input type="hidden" name="pageNo" value="<%=pageNo%>"> <font
				color="green"><%=_suc != null ? _suc : ""%></font> <font color="red"><%=_err != null ? _err : ""%></font>
			<table width="100%" border="1px">
				<tr>
					<th><input type="checkbox"
						onclick="document.querySelectorAll('input[name=ids]').forEach(c=>c.checked=this.checked)">Select
						All</th>
					<th>Id</th>
					<th>Name</th>
					<th>Description</th>
					<th>Action</th>
				</tr>

				<%
				while (it.hasNext()) {
					RoleBean bean = it.next();
				%>

				<tr align="center">
					<td><input type="checkbox" name="ids"
						value="<%=bean.getId()%>"></td>
					<td><%=bean.getId()%></td>
					<td><%=bean.getName()%></td>
					<td><%=bean.getDescription()%></td>
					<td><a href="RoleCtl?id=<%=bean.getId()%>">Edit</a></td>
				</tr>

				<%
				}
				%>
			</table>

			<table>
				<tr>
					<td><input type="submit" name="operation"
						<%=pageNo == 1 ? "disabled" : ""%>
						value="<%=BaseCtl.OP_PREVIOUS%>"> <input type="submit"
						name="operation" value="<%=BaseCtl.OP_DELETE%>"> <input
						type="submit" name="operation"
						<%=nextList.size() == 0 ? "disabled" : ""%>
						value="<%=BaseCtl.OP_NEXT%>"></td>
				</tr>
			</table>

		</form>

	</div>

</body>
</html>