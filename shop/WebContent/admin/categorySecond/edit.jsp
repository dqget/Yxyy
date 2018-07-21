<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<LINK href="${pageContext.request.contextPath}/css/Style1.css" type="text/css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/cart.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/product.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript">
			function returnTOfindAll(){
				window.location.href = "${pageContext.request.contextPath}/admin/adminCategorySecond_findAllByPage.action?page=1";
			}
		</script>
	</HEAD>
	
	<body>
		<form name="Form1" action="${pageContext.request.contextPath}/adminCategorySecond_update.action" method="post">
			<input type="hidden" name="csid" value="<s:property value="model.csid"/>"/>
			&nbsp;
			<table cellSpacing="1" cellPadding="5" width="100%" align="center" bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
						height="26">
						<strong><STRONG>编辑二级分类</STRONG>
						</strong>
					</td>
				</tr>

				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						二级分类名称：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="csname" value="<s:property value="model.csname"/>" class="bg"/>
					</td>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						所属的一级分类名称：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<!-- category.cid这样写可以直接将cid封装到二级分类对象内的一级分类对象的cid属性 -->
						<select name="category.cid">
							<s:iterator var="c" value="clist">
								<option <s:if test="model.category.cid==#c.cid">selected</s:if> value=<s:property value="#c.cid"/>><s:property value="#c.cname"/></option>
							</s:iterator>
						</select>
					</td>
				</tr>
			
				<tr>
					<td class="ta_01" style="WIDTH: 100%" align="center"
						bgColor="#f5fafe" colSpan="4">
						<button type="submit"  value="确定" class="button_ok">
							&#30830;&#23450;
						</button>

						<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
						<button type="reset" value="重置" class="button_cancel">&#37325;&#32622;</button>

						<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
						<INPUT class="button_ok" type="button" onclick="returnTOfindAll()" value="返回"/>
						<span id="Label1"></span>
					</td>
				</tr>
			</table>
		</form>
	</body>
</HTML>