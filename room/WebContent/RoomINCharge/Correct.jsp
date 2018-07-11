<%@ page language="java" import="java.util.*,JC.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<% 
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
%>
<script>
	function check(){
		if(form.CustomerName.value==""){
			window.alert("Please Fill In The CustomerName!");
			return false;
		}if(form.CustomerIDNum.value==""){
			window.alert("Please Fill In The CustomerIDNum!");
			return false;
		}if(form.CustomerBD.value==""){
			window.alert("Please Fill In The CustomerBD!");
			return false;
		}if(form.CustomerSex.value==""){
			window.alert("Please Fill In The CustomerSex!");
			return false;
		}if(form.CustomerTel.value==""){
			window.alert("Please Fill In The CustomerTel!");
			return false;
		}if(form.CustomerMail.value==""){
			window.alert("Please Fill In The CustomerMail!");
			return false;
		}if(form.MemberNum.value==""){
			window.alert("Please Fill In The MemberNum!");
			return false;
		}if(form.CustomerStatus.value==""){
			window.alert("Please Fill In The CustomerStatus!");
			return false;
		}if(form.CheckInTime.value==""){
			window.alert("Please Fill In The CheckInTime!");
			return false;
		}(form.CheckOutTime.value==""){
			window.alert("Please Fill In The CheckOutTime!");
			return false;
		}
	}
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<center>
		<form name="form" action="../correctCL" method="post">
			<h2>Correct Customer Info</h2>
			<%
				CustomerBean cb = null;
				CustomerBeanCL cbcl = new CustomerBeanCL();
				List<CustomerBean> al = cbcl.getAllcb();
				for(int i = 0 ; i < al.size() ; i++){
					if(al.get(i).getCustomerNum().equals(request.getParameter("CustomerNum"))){
						cb = al.get(i);
						break;
					}
				}
			%>
			CustomerNum:<input type="text" name="CustomerNum" readonly value="<%=cb.getCustomerNum()%>"/></br></br>
			CustomerName:<input type="text" name="CustomerName" value="<%=cb.getCustomerName() %>"/></br></br>
			CustomerIDNum:<input type="text" name="CustomerIDNum" value="<%=cb.getCustomerIDNum()%>"/></br></br>
			CustomerBD:<input type="text" name="CustomerBD" value="<%=cb.getCustomerBD()%>"/></br></br>
			CustomerSex:<input type="text" name="CustomerSex" value="<%=cb.getCustomerSex()%>"/></br></br>
			CustomerTel:<input type="text" name="CustomerTel" value="<%=cb.getCustomerTel()%>"/></br></br>
			CustomerMail:<input type="text" name="CustomerMail" value="<%=cb.getCustomerMail()%>"/></br></br>
			MemberNum:<input type="text" name="MemberNum" value="<%=cb.getMemberNum()%>"/></br></br>
			CustomerStatus:<input type="text" name="CustomerStatus" value="<%=cb.getCustomerStatus()%>"></br></br>
			CheckInTime:<input type="text" name="CheckInTime" value="<%=cb.getCheckInTime()%>"/></br></br>
			CheckOutTime:<input type="text" name="CheckOutTime" value="<%=cb.getCheckOutTime()%>"/></br></br>
			<input type="submit" name="ok" value="ok" onclick="return check();"/>
		</form>
	</center>
</body>
</html>