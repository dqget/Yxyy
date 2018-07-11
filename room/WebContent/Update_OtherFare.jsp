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
	<h2>其他消费更改</h2><br><br>
	<%
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String rnum=request.getParameter("rnum");
		String faretype=request.getParameter("faretype");
		Float fare=Float.parseFloat(request.getParameter("fare"));
		String optime=request.getParameter("optime");
		String ps=request.getParameter("ps");
		%>
	<form action="Update_OtherFare_do" method="post">
	 	<div id="inform">
			<div id="rnum"> 
				<h3>房间号： 
				<% 
					out.println("<input type='text' readonly='readonly' name='rnum' value="+rnum+">");
				%>
				</h3>
			</div>
			<br>
			<div id="faretype">
				<h3>消费类型：
				<% 
					out.println("<input type='text' readonly='readonly' name='faretype' value="+faretype+">");
				%>
				</h3>
			</div>
			<br>
			<div id="fare"> 
				<h3>消费金额：
				<% 
					out.println("<input type='text'  name='fare' value="+fare+">");
				%>
				</h3>
			</div>
			<br>
			<div id="optime">
				<h3>操作时间：
				<% 
					out.println("<input type='text' readonly='readonly' name='optime' value="+optime+">");
				%>
				</h3>
			</div>
			<br>
			<div id="ps">
				<h3>备注：
				<% 
					out.println("<input type='text'  name='ps' value="+ps+">");
				%>
				</h3>
			</div>
			<br>
		</div>
		<input id='submit' type="submit" value="确定">
	</form>
		
		<form action="OtherFareRnum_fare.jsp" method="post">
		<% 
			out.println("<input type='hidden' name='rnum' value="+rnum+">");
		%>
		
		</form>
		<br>
		<input id='submit' type="submit" onclick="window.history.back()" value="返回">
		</center>
</body>
</html>