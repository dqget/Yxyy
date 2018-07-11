<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
	function check(){
		if(form1.RoomStatus.value==""){
			window.alert("Please Fill In The RoomStatus!");
			return false;
		}if(form1.RoomStandard.value==""){
			window.alert("Please Fill In The RoomStandard!");
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
				request.setCharacterEncoding("UTF-8");
				response.setCharacterEncoding("UTF-8");
		%>
	<form name="form1" action="FreeRoom2.jsp" method="post">
		<center></br></br>
		<h2>FreeRoom</h2></br></br>
			RoomStatus:<input type="text" name="RoomStatus" value="空闲或入住"/></br></br>
			RoomStandard:<input type="text" name="RoomStandard" value="大床房、标间、豪华套房"/></br></br>
			<input type="submit" id="submit" name="确定" value="确定" onclick="return check();"/>      
		</center>	
	</form>
	<form name="form2" action="RoomIn.jsp" >
		<center>
			</br>
			<input type="submit" id="submit" name="返回" value="返回" />
		</center>
	</form>
</body>
</html>