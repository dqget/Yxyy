<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="scripts/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		
		$(".delete").click(function() {
			var lastName=$(this).next(":input").val();
			var flag=confirm("确定要删除"+lastName+"信息吗？")
			if(flag){
				//使用ajax
				var $tr=$(this).parent().parent();
				var url=this.href;
				var args={"time":new Date()};
				$.post(url,args,function(data){
					//若data=1则成功
					if(data=="1"){
						alert("删除成功!");
						$tr.remove();
					}
					//否则失败
					else{
						alert("删除失败!");
					}
				});
			}else{
				
			}
			return false;
		})
	})
</script>
<title>Insert title here</title>
</head>
<body>
	<h4>List </h4>
	<s:if test="#request.employees == null|| #ruquest.employees.size() == 0">
		没有员工
	</s:if>
	<s:else>
		<table border="1" cellpadding="10" cellspacing="0"> 
		<tr>
			<td>ID</td>
			<td>LASTNAME</td>
			<td>EMALL</td>
			<td>BIRTH</td>
			<td>CREATETIME</td>
			<td>DEPT</td>
			<td>Delete</td>
		</tr>
		<s:iterator value="#request.employees">
			<tr>
				<td>${id}</td>
				<td>${lastName}</td>
				<td>${email}</td>
				<td>
				<s:date name="birth" format="yyyy=MM-dd"/>
				</td>
				<td>
				<s:date name="birth" format="yyyy=MM-dd hh:mm:ss"/>
				</td>
				<td>${department.departmentName }</td>
				<td><a href="emp-delete?id=${id}" class="delete">Delete</a>
					<input type="hidden" value="${lastName}"/>
				 </td>
			</tr>
		</s:iterator>
		</table>
	</s:else>
</body>
</html>