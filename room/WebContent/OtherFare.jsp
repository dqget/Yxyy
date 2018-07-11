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
	<h2>查询其他消费信息</h2><br>
		<form action="OtherFareRnum_fare.jsp" method="post">
		<h3>根据房间号查询：</h3><br>
			房间号：<input type="text" name="rnum">
			<input id='submit' type="submit" value="查询">
		</form>
		
		<br><br><br>
	<form action="FareManagement.jsp">
	<input id='submit' type="submit" value="返回首页">
	</form>
	</center>
</body>
</html>