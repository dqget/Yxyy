<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
	function check(){
		if(form1.CustomerIDNum.value==""){
			window.alert("Please Fill In The CustomerIDNum!");
			return false;
		}if(form1.CustomerTel.value==""){
			window.alert("Please Fill In The CustomerTel!");
			return false;
		}if(form1.st.value==""){
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
	<form name="form1" action="CustomerRoomNF2.jsp">
		<center><br><br>
		<h2>CustomerRoomNF</h2><br><br>
			CustomerIDNum:<input type="text" name="CustomerIDNum" value=""/></br></br>
			CustomerTel:<input type="text" name="CustomerTel" value=""/></br></br>
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