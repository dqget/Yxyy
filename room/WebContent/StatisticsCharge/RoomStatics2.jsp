<%@ page language="java" import="java.util.*,JC.*" contentType="text/html; charset=utf-8" errorPage="/error.jsp"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<form action ="Statistics.jsp" method="post">
		<center><br><br>
		<h2>RoomStatics</h2><br><br>
			<%		
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
				String st = request.getParameter("st");
				String et = request.getParameter("et");
				String RoomStandard = request.getParameter("RoomStandard");
				RoomStaticsBeanCL rbcl= new RoomStaticsBeanCL();
				RoomStaticsBean rb = null;
				List<RoomStaticsBean> al = rbcl.getRoomStaticsBeanCL(RoomStandard,st,et);
				System.out.println("11111111111"+RoomStandard);
			%>
			<table border=1>
				<tr>
					<th>RoomStandard</th><th>RoomStatus</th><th>CountRN</th><th>StartTime</th><th>EndTime</th>
				</tr>
				<%
					for(int i = 0;i<al.size();i++){
						rb = al.get(i);
						
				%>
				<tr>
					<td><%=rb.getRoomStandard()%></td>
					<td><%=rb.getRoomStatus()%></td>
					<td><%=rb.getCountRN()%></td>
					<td><%=st%></td>
					<td><%=et%></td>
				</tr>
				<%
					}
				%>
			</table>
			<%
				float x=0;
				float y=0;
				if(rb!=null){
				if(rb.getRoomStatus().equals("空闲")){
					x = Float.parseFloat(rb.getCountRN());
				}else{
					y = Float.parseFloat(rb.getCountRN());
				}
			}
			%>
			空闲率：<%=x/(x+y) %>入住率：<%=y/(x+y) %></br></br>
			
		<input type="submit"  id="submit" name="返回" value="返回"/></br>
		</center>
	</form>
</body>
</html>