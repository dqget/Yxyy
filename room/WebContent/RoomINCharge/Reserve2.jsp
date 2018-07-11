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
		<center>
		<br><br>
		<h2>RoomReserve</h2><br><br>
			<%	request.setCharacterEncoding("UTF-8");
				response.setCharacterEncoding("UTF-8");
				String CustomerName = request.getParameter("CustomerName");
				String LinkTel = request.getParameter("LinkTel");
				ReserveBeanCL rb = new ReserveBeanCL();
				List<ReserveBean> al = rb.getFreeRoom(CustomerName,LinkTel);
			%>
			<table border=1>
				<tr>
					<th>FloorNum</th><th>RoomNum</th><th>StartTime</th><th>EndTime</th>
				</tr>
				<%
					for(int i = 0;i<al.size();i++){
						ReserveBean rr = al.get(i);
				%>
				<tr>
					<td><%=rr.getFloorNum()%></td>
					<td><%=rr.getRoomNum()%></td>
					<td><%=rr.getStartTime()%></td>
					<td><%=rr.getEndTime()%></td>
				</tr>
				<%
					}
				%>
			</table><br><br>
			<input type="submit" id="submit"  name="返回" value="返回"/></br>
		</center>
	</form>
</body>
</html>