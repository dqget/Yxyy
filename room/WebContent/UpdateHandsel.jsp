<%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.*" import="a.*" errorPage="error.jsp"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/style.css" rel="stylesheet" type="text/css">
<title>订金修改</title>
</head>
<body>
<center>
	<h2>订金信息更改</h2>
	<br><br>
	 <form action="Update_Handsel_do" method="post">
	<% 	request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String cnum=request.getParameter("cnum");
		String cname=request.getParameter("cname");
		Float handsel=Float.parseFloat(request.getParameter("handsel"));
		String rnum=request.getParameter("rnum");
		String optime=request.getParameter("optime");
		String ps=request.getParameter("ps");
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
			<div id="handsel"> 
				<h3>订金：
				<% 
					out.println("<input type='text'  name='handsel' value="+handsel+">");
				%>
				</h3>
			</div>
			<br>
			<div id="rnum">
				<h3>房间号：
				<% 
					out.println("<input type='text' readonly='readonly' name='rnum' value="+rnum+">");
				%>
				</h3>
			</div>
			<br>
			<div id="optime">
				<h3>操作时间：
				<% 
					out.println("<input  type='text' readonly='readonly' name='optime' value="+optime+">");
				%>
				</h3>
			</div>
			
		</div>
	<br><br><br>
		<input id='submit' type="submit" value="确定">
		
		</form>
		<br>
		<input id='submit' type="submit" onclick="window.history.back()" value="返回">
		</center>
</body>
</html>