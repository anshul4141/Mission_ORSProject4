<%@page import="in.co.rays.proj4.bean.RoleBean"%>
<%@page import="java.util.List"%>
<%@page import="in.co.rays.proj4.util.ServletUtility"%>
<%
int pageNo1 = ServletUtility.getPageNo(request);
List<RoleBean> nextList = (List<RoleBean>) request.getAttribute("nextList");
%>


<%@page import="in.co.rays.proj4.controller.BaseCtl"%>
<table width="100%">
	<tr>
		<td><input type="submit" name="operation"
			<%=pageNo1 == 1 ? "disabled" : ""%> value="<%=BaseCtl.OP_PREVIOUS%>"></td>
		<td align="center"><input type="submit" name="operation"
			value="<%=BaseCtl.OP_DELETE%>"></td>
		<td align="right"><input type="submit" name="operation"
			<%=nextList.size() == 0 ? "disabled" : ""%>
			value="<%=BaseCtl.OP_NEXT%>"></td>
	</tr>
</table>