<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>网上商城管理中心</title>
</head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link type="text/css" rel="stylesheet" href="css/text.css" /> 

<body>
<h1>管理员登录</h1> 
	<div class="main-agileinfo">
		<form method="post" action="${pageContext.request.contextPath }/admin_login.action" target="_parent" name='theForm' onsubmit="return validate()">
	  		<input type="text" name="adminname"  class="name" placeholder="Usename" placeholder="用户名" />
	        <input type="password" name="adminpassword" class="password" placeholder="Password" />
	        <center><s:actionerror /></center>
	        <input type="submit" value="Login" class="button" />
		</form>
	</div>
<div class="footer-w3l">
		<p class="agile"> &copy; 2017 xxxxxxxxxxxxx</a></p>
	</div>
</body>
</html>