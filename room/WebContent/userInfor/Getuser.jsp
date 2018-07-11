<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="jdbc.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<h1>标题</h1><br><br><br>
	<table border="1">
		<tr>
			<th>用户编号</th>
			<th>用户名</th>
			<th>用户类型</th>
			<th>用户密码</th>
			<th>用户真实姓名</th>
			<th>用户年龄</th>
			<th>用户性别</th>
			<th></th>
			<th></th>
		</tr>
		<%
			List<userInfoBean> list = (List) request.getAttribute("list");
			if(list == null){
				return;
			}else{
			for (int i = 0; i < list.size(); i++) {
		%>
		<tr>
			<td><%=list.get(i).getUserNum()%></td>
			<td><%=list.get(i).getUserName()%></td>
			<td><%=list.get(i).getUserType()%></td>
			<td><%=list.get(i).getUserPassword()%></td>
			<td><%=list.get(i).getUserTrueName()%></td>
			<td><%=list.get(i).getAge()%></td>
			<td><%=list.get(i).getSex()%></td>
			<td><a href="updateuser?id=<%=list.get(i).getUserNum()%>">修改</a>
			<td><a href="deleteuser?id=<%=list.get(i).getUserNum()%>">删除</a>
		</tr>
		<%
				}
			}
		%>

	</table>
</body>
</html>