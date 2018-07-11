<%@ page language="java" import="java.util.*,JC.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<form action ="Statistics.jsp">
		<center><br><br>
		<h2>CustomerRoomDF</h2><br><br>
			<%
				String st = request.getParameter("st");
				String et = request.getParameter("et");
				CustomerRoomDFBeanCL rb = new CustomerRoomDFBeanCL();
				List<CustomerRoomDFBean> al = rb.getCustomerRoomDFBeanCL(st,et);
			%>
			<table border=1>
				<tr>
					<th>CustomerIDNum</th><th>CustomerName</th><th>SUMDayNum</th><th>SUMActualFare</th>
				</tr>
				<%
					for(int i = 0;i<al.size();i++){
						CustomerRoomDFBean rr = al.get(i);
				%>
				<tr>
					<td><%=rr.getCustomerIDNum()%></td>
					<td><%=rr.getCustomerName()%></td>
					<td><%=rr.getSUMDayNum()%></td>
					<td><%=rr.getSUMActualFare()%></td>
				</tr>
				<%
					}
				%>
			</table>
			<input type="submit"  id="submit" name="返回" value="返回"/></br>
		</center>
	</form>
</body>
</html>