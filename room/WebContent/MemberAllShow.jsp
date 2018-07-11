<%@ page language="java" contentType="text/html; charset=utf-8" errorPage="error.jsp"
    pageEncoding="utf-8"%>
   <%@page import="a.*" import="java.util.*"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/style.css" rel="stylesheet" type="text/css"> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>会员</title>

</head>
<body>
<center>
		<h2>会员信息表</h2>
		<br>
		<table frame="box" >
		<tr>
		<th>客户编号</th>
		<th>客户姓名</th>
		<th>会员类型</th>
		<th>会员编号</th>	
		<th></th>	
		</tr>
		<% request.setCharacterEncoding("utf-8");
		   List<Getmember> l=CRUDTest.getall(); 
		   for(int i=0;i<l.size();i++){
			  	out.println("<tr>");
			   	out.println("<td>"+l.get(i).getCnum()+"</td>");
			   	out.println("<td>"+l.get(i).getCname()+"</td>");
			   	out.println("<td>"+l.get(i).getMembertype()+"</td>");   
			   	out.println("<td>"+l.get(i).getMembernum()+"</td>");  
				out.println("<td><form action='UpdateMember.jsp' method='post'>");
				out.println("<input id='submit' type='hidden' name='cnum' value="+l.get(i).getCnum()+" />");
				out.println("<input id='submit' type='hidden' name='cname' value="+l.get(i).getCname()+" />");
				out.println("<input id='submit' type='hidden' name='membertype' value="+l.get(i).getMembertype()+" />");
				out.println("<input id='submit' type='hidden' name='membernum' value="+l.get(i).getMembernum()+" />");
				out.println("<input id='submit' type='submit' value='修改'/></form></td></tr>");
		   }
		%>
		</table>
		<form action="Member.jsp" method="post">
			<input id='submit' type="submit" value="返回">
		</form>
		</center>
</body>
</html>