<%@ page language="java" contentType="text/html; charset=utf-8" errorPage="error.jsp"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/style.css" rel="stylesheet" type="text/css">
<title>会员</title>
</head>
<body>
<center>
		<h2>会员信息更改</h2>
		<br><br>
	 <form action="Update_Member_do" method="post">
	<% 	request.setCharacterEncoding("utf-8");
		String cnum=request.getParameter("cnum");
		String cname=request.getParameter("cname");
		String membertype=request.getParameter("membertype");
		String membernum=request.getParameter("membernum");
	%>
	
	 	<div id="inform">
			<div id="cnum"> 
				<h3>客户编号： 
				<% 
					out.println("<input type='text' readonly='readonly' name='cnum' value="+cnum+">");
				%>
				</h3>
			</div>
			<br>
			<div id="cname">
				<h3>客户名：
				<% 
					out.println("<input type='text' readonly='readonly' name='cname' value="+cname+">");
				%>
				</h3>
			</div>
			<br>
			<div id="membertype">
				<h3>会员类型：
				<% 
					out.println("<input type='text'  name='membertype' value="+membertype+">");
				%>
				</h3>
			</div>
			<br>
			<div id="membernum">
				<h3>会员编号：
				<% 
					out.println("<input type='text' readonly='readonly' name='membernum' value="+membernum+">");
				%>
				</h3>
			</div>
			
		</div>
		<br><br><br>
		<input id='submit' type="submit" value="修改">
		</form>
		<br>
		<input id='submit' type="submit" onclick="window.history.back()" value="返回">
		</center>
</body>
</html>