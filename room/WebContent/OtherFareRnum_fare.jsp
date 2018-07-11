<%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.*" import="a.*" errorPage="error.jsp" 
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/style.css" rel="stylesheet" type="text/css">
<title>其他消费</title>

</head>
<body>
<center>
	<h2>房间其他消费情况总表</h2>
	<%
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String rnum=request.getParameter("rnum");
		List<OtherFare> l=CRUDTest.getOtherFare(rnum);//房间号有其他页面传过来
	%>
		<table frame="box" >
		<tr>
		<th>房间号</th>
		<th>消费类型</th>
		<th>消费金额</th>
		<th>操作时间</th>
		<th>备注</th>	

		<th></th>	
		<th></th>
		</tr>
		<% 
		   for(int i=0;i<l.size();i++){
			  	out.println("<tr>");
				out.println("<td>"+l.get(i).getRnum()+"</td>"); 
			   	out.println("<td>"+l.get(i).getFaretype()+"</td>");
			   	out.println("<td>"+l.get(i).getFare()+"</td>");
			   	out.println("<td>"+l.get(i).getOptime()+"</td>");   
			   	out.println("<td>"+l.get(i).getPs()+"</td>");  

				out.println("<td><form action='Update_OtherFare.jsp' method='post'>");
				out.println("<input type='hidden' name='rnum' value="+l.get(i).getRnum()+" />");
				out.println("<input type='hidden' name='faretype' value="+l.get(i).getFaretype()+" />");
				out.println("<input type='hidden' name='fare' value="+l.get(i).getFare()+" />");
				out.println("<input type='hidden' name='optime' value="+l.get(i).getOptime()+" />");
				out.println("<input type='hidden' name='ps' value="+l.get(i).getPs()+" />");
				out.println("<input id='submit' type='submit' value='修改'/></form></td>");
				
				out.println("<td><form action='Delete_OtherFare_do' method='post'>");
				out.println("<input type='hidden' name='rnum' value="+l.get(i).getRnum()+" />");
				out.println("<input type='hidden' name='faretype' value="+l.get(i).getFaretype()+" />");
				out.println("<input type='hidden' name='fare' value="+l.get(i).getFare()+" />");
				out.println("<input type='hidden' name='optime' value="+l.get(i).getOptime()+" />");
				out.println("<input type='hidden' name='ps' value="+l.get(i).getPs()+" />");
				out.println("<input id='submit' type='submit' value='删除记录'/></form></td></tr>");
		   }
		%>
		</table>
		<% 
			if (rnum.length()>0 && rnum!=null){
		%>		
		
		<form action="Add_OtherFare.jsp" method="post">
		<input type='hidden' name='rnum' value="<%= request.getParameter("rnum")%>" />
		<input id='submit' type="submit" value="添加纪录"  >
		</form>
		<% 
			}
		%>
		<br>
		<form action="OtherFare.jsp" method="post">
		<input  id='submit' type="submit" value="返回"  >
		</form>
		</center>
</body>
</html>