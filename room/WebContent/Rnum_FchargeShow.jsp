<%@ page language="java" contentType="text/html; charset=utf-8" errorPage="error.jsp"
    pageEncoding="utf-8"%>
     <%@page import="a.*" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/style.css" rel="stylesheet" type="text/css">
<title>消费</title>
</head>
<body>
<center>
<h2>客户消费情况总表</h2>
	<table frame="box" >
		<tr>
		<th>客户编号</th>
		<th>客户姓名</th>
		<th>房间号</th>
		<th>订金</th>
		<th>其他消费总额</th>
		<th>房费</th>
		<th>总消费</th>
		<th>实际费用</th>
		</tr>
		<% request.setCharacterEncoding("utf-8");
		String rnum=request.getParameter("rnum");
		   List<Customer_Fare> l=CRUDTest.getrnum_Sum(rnum); //r001有其他页面的数据传进来
		   for(int i=0;i<l.size();i++){
			  	out.println("<tr>");
			   	out.println("<td>"+l.get(i).getCustomerNum()+"</td>");
			   	out.println("<td>"+l.get(i).getCustomerName()+"</td>");
			 	out.println("<td>"+l.get(i).getRnum()+"</td>");
			 	out.println("<td>"+l.get(i).getHandsel()+"</td>");
			 	out.println("<td>"+l.get(i).getOtherfare()+"</td>");
			 	out.println("<td>"+l.get(i).getRoomcharge()+"</td>");
			 	out.println("<td>"+l.get(i).getSumFare()+"</td>");
			 	out.println("<td>"+l.get(i).getActualfare()+"</td>");
				out.println("</tr>");
		   }
		%>
		</table>
		<form action="Fcharge.jsp" method="post">
		<input id='submit' type="submit" value="返回"  >
		</form>
		</center>
</body>
</html>