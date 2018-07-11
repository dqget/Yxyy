<%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.*" import="a.*" errorPage="error.jsp"
    pageEncoding="utf-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/style.css" rel="stylesheet" type="text/css">
<title>订金</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String tell=request.getParameter("tell");
		List<Customer_Fare> l=CRUDTest.getTell_Handsel(tell);//电话有其他页面传过来
		
	%>
	<center>
	<h2>客户订金表</h2>
		<br>
	<table frame="box" >
		<tr>
		<th>客户编号</th>
		<th>客户姓名</th>
		<th>身份证号</th>
		<th>订金</th>
		<th>房间号</th>	
		<th>操作时间</th>
		<th></th>	
		<th></th>
		</tr>
		<% 
		   for(int i=0;i<l.size();i++){
			  	out.println("<tr>");
			   	out.println("<td>"+l.get(i).getCustomerNum()+"</td>");
			   	out.println("<td>"+l.get(i).getCustomerName()+"</td>");
			   	out.println("<td>"+l.get(i).getCustomerIDNum()+"</td>");   
			   	out.println("<td>"+l.get(i).getHandsel()+"</td>");  
				out.println("<td>"+l.get(i).getRnum()+"</td>"); 
				out.println("<td>"+l.get(i).getOPTime()+"</td>"); 
				
				out.println("<td><form action='UpdateHandsel.jsp' method='post'>");
				out.println("<input type='hidden' name='cnum' value="+l.get(i).getCustomerNum()+" />");
				out.println("<input type='hidden' name='cname' value="+l.get(i).getCustomerName()+" />");
				out.println("<input type='hidden' name='cidnum' value="+l.get(i).getCustomerIDNum()+" />");
				out.println("<input type='hidden' name='handsel' value="+l.get(i).getHandsel()+" />");
				out.println("<input type='hidden' name='rnum' value="+l.get(i).getRnum()+" />");
				out.println("<input type='hidden' name='optime' value="+l.get(i).getOPTime()+" />");
				out.println("<input id='submit' type='submit' value='修改'/></form></td>");
				
				out.println("<td><form action='Delete_Handsel_do' method='post'>");
				out.println("<input type='hidden' name='cnum' value="+l.get(i).getCustomerNum()+" />");
				out.println("<input type='hidden' name='cname' value="+l.get(i).getCustomerName()+" />");
				out.println("<input type='hidden' name='tell' value="+l.get(i).getCustomerTel()+" />");
				out.println("<input type='hidden' name='handsel' value="+l.get(i).getHandsel()+" />");
				out.println("<input type='hidden' name='rnum' value="+l.get(i).getRnum()+" />");
				out.println("<input type='hidden' name='optime' value="+l.get(i).getOPTime()+" />");
				out.println("<input id='submit' type='submit' value='删除'/></form></td></tr>");
				
		   }
		%>
		</table>
		<form action="Handsel.jsp" method="post">
			<input id='submit' type="submit" value="返回">
		</form>
		</center>
</body>
</html>