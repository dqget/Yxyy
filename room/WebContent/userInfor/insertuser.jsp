<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<center>
	<h2>标题</h2><br><br><br>
	<div>
		<form action="../insertuser" method="post">
			<table>
				<tr>
					<th>用户编号</th>
<!-- 					<th>：</th> -->
					<th><input id="r1_input" name="UserNum" type="text"
						style="color: rgb(153, 153, 153);"></th>
				</tr>
				<tr>
					<th>用户姓名</th>
<!-- 					<th>：</th> -->
					<th><input id="r2_input" name="UserName" type="text"
						style="color: rgb(153, 153, 153);"></th>
				</tr>
				<tr>
					<th>用户类型</th>
<!-- 					<th>：</th> -->
					<th><input id="r3_input" name="UserType" type="text"
						style="color: rgb(153, 153, 153);"></th>
				</tr>
				<tr>
					<th>用户密码</th>
<!-- 					<th>：</th> -->
					<th><input id="r4_input" name="UserPassword" type="text"
						style="color: rgb(153, 153, 153);"></th>
				</tr>
				<tr>
					<th>用户真实姓名</th>
<!-- 					<th>：</th> -->
					<th><input id="r5_input" name="UserTrueName" type="text"
						style="color: rgb(153, 153, 153);"></th>
				</tr>
				<tr>
					<th>用户年龄</th>
<!-- 					<th>：</th> -->
					<th><input id="r6_input" name="Age" type="text"
						style="color: rgb(153, 153, 153);"></th>
				</tr>
				<tr>
					<th>用户性别</th>
<!-- 					<th>：</th> -->
					<th><input id="r7_input" name="Sex" type="text"
						style="color: rgb(153, 153, 153);"></th>
				</tr>
				<tr>
<!-- 					<th></th>
					<th></th> --><th></th>
					<th><button id='submit'value="提交">提交</button></th>
				</tr>
			</table>
		</form>
	</div>
	</center>
</body>
</html>