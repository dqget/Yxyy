<%@ page language="java" import="java.util.*,JC.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<% 
request.setCharacterEncoding("utf-8");
response.setCharacterEncoding("utf-8");
%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
		<%
		CustomerBeanCL cbcl = new CustomerBeanCL();
		List<CustomerBean> al = cbcl.getAllcb();
		%>
		<center></br></br>
		<h2>CustomerCharge.jsp</h2></br></br></br>
		<table border=1>
			<tr>
				<th>CustomerNum</th><th>CustomerName</th><th>CustomerIDNum</th><th>CustomerBD</th>
				<th>CustomerSex</th><th>CustomerTel</th><th>CustomerMail</th><th>MemberNum</th>
				<th>CustomerStatus</th><th>CheckInTime</th><th>CheckOutTime</th><th>RorC</th><th>Flush</th>
			</tr>
			<%
			for(int i = 0;i<al.size();i++){
				CustomerBean cb = al.get(i);
			%>
			<tr>
				<td><%=cb.getCustomerNum()%></td>
				<td><%=cb.getCustomerName()%></td>
				<td><%=cb.getCustomerIDNum()%></td>
				<td><%=cb.getCustomerBD()%></td>
				<td><%=cb.getCustomerSex()%></td>
				<td><%=cb.getCustomerTel()%></td>
				<td><%=cb.getCustomerMail()%></td>
				<td><%=cb.getMemberNum()%></td>
				<td><%=cb.getCustomerStatus()%></td>
				<td><%=cb.getCheckInTime()%></td>
				<td><%=cb.getCheckOutTime()%></td>
				<td>
				<a href="Correct.jsp?CustomerNum=<%=cb.getCustomerNum()%>" onclick="return window.confirm("Are you sure?")">修改</a>
				<a href="../removeCL?CustomerNum=<%=cb.getCustomerNum()%>" onclick="return window.confirm("Are you sure?")">删除</a></td>
				<td>
					<form action="../flushCL" method="post">
						<center>
							<input id='submit' type='hidden' name='a1' value="<%=cb.getCheckInTime()%>" />
							<input id='submit' type='hidden' name='a2' value="<%=cb.getCheckOutTime()%>" />
							<input id='submit' type='hidden' name='a3' value="<%=cb.getCustomerNum()%>" />
							<input type="submit" id="submit" name="刷新" value="刷新"/></br>
						</center>
					</form>
				</td>
			</tr>
			<%
			}
			%>
		</table>
	<form action="RoomIn.jsp">
		<input type="submit" id="submit" name="返回" value="返回"/></br>
		</center>
	</form>
	
</body>
</html>