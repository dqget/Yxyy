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
	<form action ="RoomIn.jsp">
		<center><br><br>
		<h2>RealRoomIn</h2><br><br>
			<%
				RealRoomInBeanCL cbcl = new RealRoomInBeanCL();
				List<RealRoomInBean> al = cbcl.getAllrrib();
			%>
			<table border=1>
				<tr>
					<th>CustomerNum</th><th>RoomNum</th><th>CheckInTime</th><th>CheckOutTime</th>
					<th>ActualFare</th><th>UserNum</th><th>DayNum</th>
				</tr>
				<%
					for(int i = 0;i<al.size();i++){
						RealRoomInBean rrib = al.get(i);
				%>
				<tr>
					<td><%=rrib.getCustomerNum()%></td>
					<td><%=rrib.getRoomNum()%></td>
					<td><%=rrib.getCheckInTime()%></td>
					<td><%=rrib.getCheckOutTime()%></td>
					<td><%=rrib.getActualFare()%></td>
					<td><%=rrib.getUserNum()%></td>
					<td><%=rrib.getDayNum()%></td>
				</tr>
				<%
					}
				%>
			</table>
			<input type="submit" id="submit" name="返回" value="返回"/></br>
		</center>
	</form>
</body>
</html>