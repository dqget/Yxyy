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
	<form action ="RoomIn.jsp"><br><br>
		<center>
		<h2>FreeRoom</h2><br><br>
			<%	request.setCharacterEncoding("UTF-8");
				response.setCharacterEncoding("UTF-8");
				String RoomStatus = request.getParameter("RoomStatus");
				String RoomStandard = request.getParameter("RoomStandard");
				
				RoomBeanCL cbcl = new RoomBeanCL();
				List<RoomBean> al = cbcl.getFreeRoom(RoomStatus,RoomStandard);
			%>
			<table border=1>
				<tr>
					<th>FloorNum</th><th>RoomNum</th><th>RoomCharge</th>
				</tr>
				<%
					
					for(int i = 0;i<al.size();i++){
						RoomBean rr = al.get(i);
				%>
				<tr>
					<td><%=rr.getFloorNum() %></td>
					<td><%=rr.getRoomNum() %></td>
					<td><%=rr.getRoomCharge() %></td>
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