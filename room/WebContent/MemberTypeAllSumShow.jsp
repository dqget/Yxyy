<%@ page language="java" contentType="text/html; charset=utf-8" errorPage="error.jsp"
    pageEncoding="utf-8"%>
   <%@page import="a.*" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/style.css" rel="stylesheet" type="text/css"> 
<title>会员</title>
</head>
<body> <center>

		<h2>会员类型数量表</h2>
		<br>
		<table frame="box" >
		<tr>
		<th>会员类型</th>
		<th>数量</th>
		<th> </th>
		</tr>
		<% request.setCharacterEncoding("utf-8");
		   List<TJmember> l=CRUDTest.getTJmember(); 
		   for(int i=0;i<l.size();i++){
			  	out.println("<tr>");
			   	out.println("<td>"+l.get(i).getMembertype()+"</td>");
			   	out.println("<td>"+l.get(i).getSum()+"</td>");
			   	out.println("<td><form action='MemberType_MemberShow.jsp' method='post'>");
			   	out.println("<input type='hidden' name='membertype' value="+l.get(i).getMembertype()+" /><input id='submit' type='submit' value='查看'/></form>");
				out.println("</td></tr>");
		   }
		%>
		</table>
		<form action="Member.jsp" method="post">
			<input id='submit' type="submit" value="返回">
		</form>
		</center>
</body>
</html>