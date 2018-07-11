<%@ page language="java" contentType="text/html; charset=utf-8" errorPage="error.jsp"

    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/style.css" rel="stylesheet" type="text/css"> 
<title>会员</title>
</head>
<body><center><br><br>
<h2>Member</h2>
		<br><br>
	<form action="MemberTypeAllSumShow.jsp" method="post">
	<h3>根据会员类别查询客户基本信息：</h3>
	<br>
	<input id="submit" type="submit" value="进入">
	</form>
	<br/>
	<form action="MemberAllShow.jsp">
	<h3>查询所有客户信息：</h3>
	<br>
	<input id="submit" type="submit" value="进入">
	</form>
	<br>
	<a href="Main.jsp">退出</a>
	<h2></h2>
	Welcome to 会员管理!
	</center>
</body>
</html>