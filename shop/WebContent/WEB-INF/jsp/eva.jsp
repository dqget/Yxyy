<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0043)http://localhost:8080/mango/cart/list.jhtml -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>我的订单页面</title>
<link href="${pageContext.request.contextPath}/css/common.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/cart.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/product.css"
	rel="stylesheet" type="text/css" />

</head>
<body>

	<div class="container header">
		<div class="span5">
			<div class="logo">
				<a href="./网上商城/index.htm"> <img
					src="${pageContext.request.contextPath}/image/r___________renleipic_01/logo1.gif" /> </a>
			</div>
		</div>
		<div class="span9">
			<div class="headerAd">
				<img src="${pageContext.request.contextPath}/image/header.jpg"
					width="320" height="50" alt="正品保障" title="正品保障" />
			</div>
		</div>

		<%@ include file="menu.jsp"%>

	</div>

	<div class="container cart">

		<div class="span24">

			<div class="step step1">
				<ul>

					<li class="current"></li>
					<li>订单</li>
				</ul>
			</div>

		<form action="${pageContext.request.contextPath }/evaluate_addEva.action">
			<table>
				<tbody>
						<tr>
							<th>图片</th>
							<th>商品</th>
							<th>价格</th>
						</tr>
							<tr>
								<td width="60">
									<img src="${ pageContext.request.contextPath }/<s:property value="product.image"/>" />
								</td>
								<td><s:property value="product.pname" /></td>
								<td><s:property value="product.shop_price" /></td>
							</tr>
							<tr>
								<td colspan="5">评论</td>
							</tr>
							<tr>
								<td>用户名称</td>
								<td>评论内容</td>
								<td>评论星级</td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td><s:property value="#session.existUser.userName"/></td>
								<td><input name="econ" value="请输入评论内容" style="width:400pt"></input></td>
								<td>
									<select name="eva">
										<option>1</option>
										<option>2</option>
										<option>3</option>
										<option>4</option>
										<option selected>5</option>
									</select>
									星好评
								</td>
								<td></td>
								<td></td>
							</tr>
				</tbody>
			</table>
			<div style="margin:20pt">
				<center>
					<input type="submit" value="提交评论" style="width:100pt"/>
				</center>
			</div>
		</form>

		</div>

	</div>
	<div class="container footer">
		<div class="span24">
			<div class="footerAd">
				<img src="image\r___________renleipic_01/footer.jpg" alt="我们的优势"
					title="我们的优势" height="52" width="950"/>
			</div>
		</div>
		<div class="span24">
			<ul class="bottomNav">
				<li><a href="#">关于我们</a> |</li>
				<li><a href="#">联系我们</a> |</li>
				<li><a href="#">诚聘英才</a> |</li>
				<li><a href="#">法律声明</a> |</li>
				<li><a>友情链接</a> |</li>
				<li><a target="_blank">支付方式</a> |</li>
				<li><a target="_blank">配送方式</a> |</li>
				<li><a>SHOP++官网</a> |</li>
				<li><a>SHOP++论坛</a></li>
			</ul>
		</div>
		<div class="span24">
			<div class="copyright">Copyright © 2005-2015 网上商城 版权所有</div>
		</div>
	</div>
</body>
</html>