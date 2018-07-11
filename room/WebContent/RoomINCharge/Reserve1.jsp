<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
	function check(){
		if(form1.CustomerName.value==""){
			window.alert("Please Fill In The CustomerName!");
			return false;
		}if(form1.LinkTel.value==""){
			window.alert("Please Fill In The LinkTel!");
			return false;
		}
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<form name="form1" action="Reserve2.jsp" method="post">
		<center><br><br>
		<h2>RoomReserve</h2><br><br>
			CustomerName:<input type="text" name="CustomerName" value=""/></br></br>
			LinkTel:<input type="text" name="LinkTel" value=""/></br></br><br><br>
			<input type="submit" id="submit" name="确定" value="确定" onclick="return check();"/>      
		</center>	
	</form>
	<form name="form2" action="RoomIn.jsp">
		<center>
			</br>
			<input type="submit" id="submit"  name="返回" value="返回" />
		</center>
	</form>
</body>
</html>