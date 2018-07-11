<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
	function check(){
		if(form1.RoomNum.value==""){
			window.alert("Please Fill In The RoomNum!");
			return false;
		}
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<form name="form1" action="Room2.jsp">
		<center><br><br>
		<h2>RoomCharge</h2><br><br>
			RoomNum:<input type="text" name="RoomNum" value=""/></br></br><br><br>
			<input type="submit" id="submit" name="确定" value="确定" onclick="return check();"/>
			
		</center>	
	</form>
	<form name="form2" action="RoomIn.jsp">
		<center>
			</br>
			<input type="submit" id="submit" name="返回" value="返回" />
		</center>
	</form>
</body>
</html>