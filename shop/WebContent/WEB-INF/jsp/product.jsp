<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
<title>网上商城</title>
<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/css/product.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/css/cart.css" rel="stylesheet" type="text/css" />
<script>
function saveCart(){
	document.getElementById("cartForm").submit();
}
function increase(pnum){
	var count = parseInt(document.getElementById("count").value);
	if(count<pnum){
		document.getElementById("count").value = count+1;
	}
}
function decrease(){
	var count = parseInt(document.getElementById("count").value);
	if(count-1>0){
		document.getElementById("count").value = count-1;
	}
}
function waySelectChange(){
    var myselect = document.getElementById("fw");
	var index = myselect.selectedIndex; 
	var fw = myselect.options[index].value;
	if(fw=="3"){
		findcon.style.display='none';
		price_SB.style.display='';
	}else{
		findcon.style.display='';
		price_SB.style.display='none';
	}
}
function judgePrice(){
	var smallprice = parseInt(document.getElementById("smallprice").value);
	var bigprice = parseInt(document.getElementById("bigprice").value);
	if(smallprice<0){
		document.getElementById("smallprice").value = "0";
		document.getElementById("bigprice").value = "0";
		window.alert("输入的价格下限过小");
	}else if(bigprice<smallprice){
		document.getElementById("smallprice").value = "0";
		document.getElementById("bigprice").value = "0";
		window.alert("输入的价格上限过小");
	}else if(bigprice>100000){
		document.getElementById("smallprice").value = "0";
		document.getElementById("bigprice").value = "0";
		window.alert("输入的价格上限过大");
	}
}
</script>

</head>
<body>

<div class="container header">
	<div class="span5">
		<div class="logo">
			<a>
				<img src="${pageContext.request.contextPath}/image/r___________renleipic_01/logo1.gif"/>
			</a>
		</div>
	</div>
	<div class="span9">
<div class="headerAd">
					<img src="image\r___________renleipic_01/header.jpg" alt="正品保障" title="正品保障" height="50" width="320"/>
</div>	</div>
<%@ include file="menu.jsp" %>
</div><div class="container productContent">
		<div class="span6">
			<div class="hotProductCategory">
				<form action="${pageContext.request.contextPath}/product_findByWay.action?page=1">
					<center><strong>查询商品</strong></center>
					<div style="margin:10pt">
						查询条件
						<select id="fw" name="fw" onclick="waySelectChange()">
							<option value="1">商品编号</option>
							<option value="2">商品名称</option>
							<option value="3">商品价格</option>
						</select>
					</div>
					<div id="findcon" name="findcon" style="margin:10pt">
						查询内容<input name="fp" id="fp" value=""/>
					</div>
					<div id="price_SB" name="price_SB" style="margin:10pt;display:none">
						价格区间
						<input name="smallprice" style="width:20pt" id="smallprice" value="0" onchange="judgePrice()"/>---
						<input name="bigprice" style=" width:20pt" id="bigprice" value="0" onchange="judgePrice()"/>
					</div>
					<div style="margin:10pt">
						<input type="submit" value="查询商品"></input>
					</div>
				</form>
				<s:iterator value="#session.cList" var="c">
						<dl>
							<dt>
								<a href="${pageContext.request.contextPath}/product_findByCid?cid=<s:property value="#c.cid"/>&page=1"><s:property value="#c.cname"/></a>
							</dt>
							<s:iterator value="#c.categorySeconds" var="cs">
									<dd>
										<a href="${pageContext.request.contextPath}/product_findByCsid?csid=<s:property value="#cs.csid"/>&page=1">><s:property value="#cs.csname"/></a>
									</dd>
							</s:iterator>		
						</dl>
				</s:iterator>
			</div>
			

		</div>
		<div class="span18 last">
			
			<div class="productImage">
					<a title="" style="outline-style: none; text-decoration: none;" id="zoom" href="http://image/r___________renleipic_01/bigPic1ea8f1c9-8b8e-4262-8ca9-690912434692.jpg" rel="gallery">
						<div class="zoomPad"><img style="opacity: 1;" title="" class="medium" src="${pageContext.request.contextPath}/<s:property value="model.image"/>"><div style="display: block; top: 0px; left: 162px; width: 0px; height: 0px; position: absolute; border-width: 1px;" class="zoomPup"></div><div style="position: absolute; z-index: 5001; left: 312px; top: 0px; display: block;" class="zoomWindow"><div style="width: 368px;" class="zoomWrapper"><div style="width: 100%; position: absolute; display: none;" class="zoomWrapperTitle"></div><div style="width: 0%; height: 0px;" class="zoomWrapperImage"><img src="%E5%B0%9A%E9%83%BD%E6%AF%94%E6%8B%89%E5%A5%B3%E8%A3%852013%E5%A4%8F%E8%A3%85%E6%96%B0%E6%AC%BE%E8%95%BE%E4%B8%9D%E8%BF%9E%E8%A1%A3%E8%A3%99%20%E9%9F%A9%E7%89%88%E4%BF%AE%E8%BA%AB%E9%9B%AA%E7%BA%BA%E6%89%93%E5%BA%95%E8%A3%99%E5%AD%90%20%E6%98%A5%E6%AC%BE%20-%20Powered%20By%20Mango%20Team_files/6d53c211-2325-41ed-8696-d8fbceb1c199-large.jpg" style="position: absolute; border: 0px none; display: block; left: -432px; top: 0px;"></div></div></div><div style="visibility: hidden; top: 129.5px; left: 106px; position: absolute;" class="zoomPreload">Loading zoom</div></div>
					</a>
				
			</div>
			<!-- 获取action中模型驱动的对象   （model即为product）  -->
			<div class="name"><s:property value="model.pname"/> </div>
			<div class="sn">
				<div>商品编号：<s:property value="model.pid"/></div>
			</div>
			<div class="info">
				<dl>
					<dt>商城价:</dt>
					<dd>
						<strong>￥：<s:property value="model.shop_price"/>元</strong>
							参 考 价：
						<del>￥:<s:property value="model.market_price"/>元</del>
						
					</dd>
				</dl>
						库存：
						<strong><s:property value="model.pnum"/></strong>
					<dl>
						<dt>促销:</dt>
						<dd>
								<a target="_blank" title="限时抢购 (2018-07-10 ~ 2018-07-21)">限时抢购</a>
						</dd>
					</dl>
					<dl>
						<dt>    </dt>
						<dd>
							<span>    </span>
						</dd>
					</dl>
			</div>
			<s:if test="model.pnum>0">
				<form id="cartForm" action="${pageContext.request.contextPath}/cart_addCart.action" method="post">
					<input type="hidden" id="pid" name="pid" value="<s:property value="model.pid"/>"/>
					<div class="action">
						<dl class="quantity">
							<dt>购买数量:</dt>
							<dd>
								<input id="count" name="count" value="1" maxlength="4" type="text" readonly="readonly"/>
								<div>
									<span id="increase" class="increase" onclick="increase(<s:property value="model.pnum"/>)">&nbsp;</span>
									<span id="decrease" class="decrease" onclick="decrease()">&nbsp;</span>
								</div>
							</dd>
						</dl>
						<div class="buy">
							<input id="addCart" class="addCart" value="加入购物车" type="button" onclick="saveCart()"/>
						</div>
					</div>
				</form>
			</s:if>
			<s:else>
				<strong>库存为0！暂停销售！</strong>
			</s:else>
			<div id="bar" class="bar">
				<ul>
						<li id="introductionTab">
							<a href="#introduction">商品介绍</a>
						</li>
						
				</ul>
			</div>
				
				<div id="introduction" style="justify-content:center" name="introduction" class="introduction">
					<div class="title">
						<strong><s:property value="model.pdesc"/></strong>
					</div>
					<div style="justify-content:center">
						<img src="${pageContext.request.contextPath}/<s:property value="model.image"/>"/>
					</div>
					<div id="bar" class="bar" style="margin-top:10pt">
						<ul>
								<li id="evaluation">
									<a href="#evaluation">商品评论</a>
								</li>
						</ul>
					</div>
					<div class="container cart" style="width:520pt;height:100%">
					
					
						<table>
							<tbody>
								<tr>
									<th colspan="5">商品平均评价：<s:if test="aveEva>0"><s:property value="aveEva"/>星好评</s:if>
																<s:elseif test="aveEva==0">&nbsp;&nbsp;(暂无评价)</s:elseif>
									&nbsp;&nbsp;&nbsp;&nbsp;<font color="red"></font>
									</th>
								</tr>
								<tr>
									<th>评论编号</th>
									<th>用户名称</th>
									<th>商品评价</th>
									<th>评价日期</th>
									<th>评价星级</th>
								</tr>
								<s:iterator value="eList" var="e" status="status">
									<tr>
										<td><s:property value="#status.count"/></td>
										<td><s:property value="#e.user.userName"/></td>
										<td><s:property value="#e.econ"/></td>
										<td><s:property value="#e.edate"/></td>
										<td><s:property value="#e.eva"/>星好评</td>
									</tr>
								</s:iterator>
							</tbody>
						</table>
						
						
					</div>
				</div>
		</div>
	</div>
<div class="container footer">
	<div class="span24">
		<div class="footerAd">
					<img src="image\r___________renleipic_01/footer.jpg" alt="我们的优势" title="我们的优势" height="52" width="950"/>
</div>
</div>
	<div class="span24">
		<ul class="bottomNav">
					<li>
						<a href="#">关于我们</a>
						|
					</li>
					<li>
						<a href="#">联系我们</a>
						|
					</li>
					<li>
						<a href="#">诚聘英才</a>
						|
					</li>
					<li>
						<a href="#">法律声明</a>
						|
					</li>
					<li>
						<a>友情链接</a>
						|
					</li>
					<li>
						<a target="_blank">支付方式</a>
						|
					</li>
					<li>
						<a target="_blank">配送方式</a>
						|
					</li>
					<li>
						<a >SHOP++官网</a>
						|
					</li>
					<li>
						<a>SHOP++论坛</a>
						
					</li>
		</ul>
	</div>
	<div class="span24">
		<div class="copyright">Copyright © 2005-2015 网上商城 版权所有</div>
	</div>
</div>
</body>
</html>