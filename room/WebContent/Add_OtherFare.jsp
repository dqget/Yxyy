<%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.*" import="a.*" errorPage="error.jsp" import="a.*"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/style.css" rel="stylesheet" type="text/css">
<title>其他消费</title>

</head>
<body>
<center><br><br>
		<h2>AddOtherFare</h2><br><br>
	<%
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String rnum=request.getParameter("rnum");
		
		%>
	<form action="Add_OtherFare_do" method="post">
	 	<div id="inform">
			<div id="rnum"> 
				房间号： 
				<% 
					out.println("<input type='text' readonly='readonly' name='rnum' value="+rnum+">");
				%>
			</div>
			<br><br>
			<div id="faretype">
				消费类型：
				<select name="faretype">
				  <option  value="早餐费" >早餐费</option>
				  <option  value="饮料">饮料</option>
				  <option  value="洗衣费">洗衣费</option>
				</select>
			</div><br><br>
				<div id="fare"> 
				消费金额：
				<% 
					out.println("<input type='text'  name='fare' >");
				%>
			</div><br><br>
			<div id="optime">
				操作时间：
				<% 
					out.println("<input type='date' name='optime' >");
				%>
			</div><br><br>
			<div id="ps">
				备注：
				<% 
					out.println("<input type='text'  name='ps' >");
				%>
			</div>
		</div><br><br>
		<input type="submit"  id="submit"  value="确定">
	</form>
		<br><br>
		<form action="OtherFareRnum_fare.jsp" method="post">
		<% 
			out.println("<input type='hidden' name='rnum' value="+rnum+">");
		%>
		<input type="submit"  id="submit"  value="返回"  >
		</form>
		</center>
</body>
</html>