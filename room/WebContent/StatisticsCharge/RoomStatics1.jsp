<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
	function check(){
		if(form1.st.value==""){
			window.alert("Please Fill In The st!");
			return false;
		}if(form1.et.value==""){
			window.alert("Please Fill In The et!");
			return false;
		}
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<%
request.setCharacterEncoding("utf-8");
response.setCharacterEncoding("utf-8");
%>
	<form name="form1" action="RoomStatics2.jsp" method="post">
		<center><br><br>
		<h2>RoomStatics</h2><br><br>
			<div id="RoomStandard">
				RoomStandard：
				<select name="RoomStandard">
				  <option  value="大床房" >大床房</option>
				  <option  value="标间">标间</option>
				  <option  value="豪华套房">豪华套房</option>
				</select>
			</div></br></br>
			StartTime:<input type="text" name="st" value=""/></br></br>
			EndTime:<input type="text" name="et" value=""/></br></br>
			<input type="submit"  id="submit" name="确定" value="确定" onclick="return check();"/>      
		</center>	
	</form>
	<form name="form2" action="Statistics.jsp">
		<center>
			</br>
			<input type="submit"  id="submit" name="返回" value="返回" />
		</center>
	</form>
</body>
</html>