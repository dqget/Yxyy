<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jdbc.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<h1>标题</h1><br><br><br>
	<%
		request.setCharacterEncoding("utf-8");
		userInfoBean uib = (userInfoBean)request.getAttribute("uib");
		if(uib==null){
			return;
		}else{
	%>
	<div>
		<form action="updatediscount2" method="post">
			<table>
				<tr>
					<th>原用户名</th>
					<th>：</th>
					<th><%=uib.getUserName() %></th>
				</tr>
				<tr>
					<th>用户名</th>
					<th>：</th>
					<th><input id="r1_input" name="UserName" type="text"
						style="color: rgb(153, 153, 153);"></th>
				</tr>
				<tr>
					<th>原用户密码</th>
					<th>：</th>
					<th><%=uib.getUserPassword() %></th>
				</tr>
				<tr>
					<th>用户密码</th>
					<th>：</th>
					<th><input id="r2_input" name="UserPassword" type="text"
						style="color: rgb(153, 153, 153);"></th>
				</tr>
				<tr>
					<th>原用户真实姓名</th>
					<th>：</th>
					<th><%=uib.getUserTrueName() %></th>
				</tr>
				<tr>
					<th>用户真实姓名</th>
					<th>：</th>
					<th><input id="r2_input" name="UserTrueName" type="text"
						style="color: rgb(153, 153, 153);"></th>
						<input name="UserNum" type="hidden" value=<%=uib.getUserNum() %>>
				</tr>
				<tr>
					<th></th>
					<th></th>
					<th><button value="提交">提交</button></th>
				</tr>
			</table>
		</form>
	</div>
	<%} %>
</body>
</html>