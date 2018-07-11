<%@ page language="java" contentType="text/html; charset=utf-8" errorPage="error.jsp"
    pageEncoding="utf-8"%>
   <%@page import="a.*" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/style.css" rel="stylesheet" type="text/css">
<title>其他消费情况</title>
</head>
<body>
	<table frame="box" >
		<tr>
		<th>房间号</th>
		<th>消费类型</th>
		<th>消费金额</th>
		<th>操作时间</th>
		<th>备注</th>
		</tr>
		<% request.setCharacterEncoding("utf-8");
		String rnum=request.getParameter("rnum");
		   List<OtherFare> l=CRUDTest.getOtherFare(rnum); //r001有其他页面的数据传进来
		   for(int i=0;i<l.size();i++){
			  	out.println("<tr>");
			   	out.println("<td>"+l.get(i).getRnum()+"</td>");
			   	out.println("<td>"+l.get(i).getFaretype()+"</td>");
			 	out.println("<td>"+l.get(i).getFare()+"</td>");
			 	out.println("<td>"+l.get(i).getOptime()+"</td>");
			 	out.println("<td>"+l.get(i).getPs()+"</td>");
			 	
			   	out.println("<td><form action='' method='post'><input type='submit' value='修改'></td>");
			   	out.println("<input type='hidden' name='name' value="+l.get(i).getRnum()+" />");
				out.println("<input type='hidden' name='name' value="+l.get(i).getFaretype()+" />");
				out.println("<input type='hidden' name='name' value="+l.get(i).getFare()+" />");
				out.println("<input type='hidden' name='name' value="+l.get(i).getOptime()+" />");
				out.println("<input type='hidden' name='name' value="+l.get(i).getPs()+" /></form>");
				
				out.println("<td><form action='' method='post'><input type='submit' value='删除'></td>");
			   	out.println("<input type='hidden' name='name' value="+l.get(i).getRnum()+" />");
				out.println("<input type='hidden' name='name' value="+l.get(i).getFaretype()+" />");
				out.println("<input type='hidden' name='name' value="+l.get(i).getFare()+" />");
				out.println("<input type='hidden' name='name' value="+l.get(i).getOptime()+" />");
				out.println("<input type='hidden' name='name' value="+l.get(i).getPs()+" /></form>");
				out.println("</tr>");
		   }
		%>
		</table>
</body>
</html>