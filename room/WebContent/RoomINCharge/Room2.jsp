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
		<h2>RoomCharge</h2><br><br>
			<%
				String RoomNum = request.getParameter("RoomNum");
				RoomBeanCL rbcl= new RoomBeanCL();
				List<RoomBean> al = rbcl.getRoom(RoomNum);
			%>
			<table border=1>
				<tr>
					<th>RoomNum</th><th>FloorNum</th><th>RoomStandard</th><th>RoomCharge</th>
					<th>RoomPosition</th><th>RoomStatus</th><th>DateTime</th>
				</tr>
				<%
					for(int i = 0;i<al.size();i++){
						RoomBean rb = al.get(i);
				%>
				<tr>
					<td><%=rb.getRoomNum()%></td>
					<td><%=rb.getFloorNum()%></td>
					<td><%=rb.getRoomStandard()%></td>
					<td><%=rb.getRoomCharge()%></td>
					<td><%=rb.getRoomPosition()%></td>
					<td><%=rb.getRoomStatus()%></td>
					<td><%=rb.getDateTime()%></td>
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