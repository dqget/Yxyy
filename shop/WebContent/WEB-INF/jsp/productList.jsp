<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0048)http://localhost:8080/mango/product/list/1.jhtml -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>网上商城</title>
<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/css/product.css" rel="stylesheet" type="text/css"/>
<script>
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
    function judgeInput(){
    	if(document.getElementById("fp").value == ""){
    		window.alert("您还没有输入查询的内容");
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
			<a href="http://localhost:8080/mango/">
				<img src="${pageContext.request.contextPath}/image/r___________renleipic_01/logo1.gif"/>
			</a>
		</div>
	</div>
	<div class="span9">
<div class="headerAd">
					<img src="${pageContext.request.contextPath}/image/header.jpg" width="320" height="50" alt="正品保障" title="正品保障"/>
</div>	</div>
	<%@ include file="menu.jsp" %>
</div>	
<div class="container productList">
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
								<a href="${pageContext.request.contextPath}/product_findByCid.action?cid=<s:property value="#c.cid"/>&page=1"><s:property value="#c.cname"/></a>
							</dt>
							<s:iterator value="#c.categorySeconds" var="cs">
									<dd>
										<a href="${pageContext.request.contextPath}/product_findByCsid.action?csid=<s:property value="#cs.csid"/>&page=1">><s:property value="#cs.csname"/></a>
									</dd>
							</s:iterator>		
						</dl>
				</s:iterator>
			</div>
		</div>
		<div class="span18 last">
			
			<form id="productForm" method="get">
				<div id="result" class="result table clearfix">
						<ul>
							<s:iterator value="pageBean.list" var="p">
									<li>
										<a href="${ pageContext.request.contextPath }/product_findByPid.action?pid=<s:property value="#p.pid"/>">
											<img src="${pageContext.request.contextPath}/<s:property value="#p.image"/>" width="170" height="170"  style="display: inline-block;"/>		   
											<span class="intro">
											 <s:property value="#p.pname"/>
											</span>
											<span class="price">
												商城价： ￥<s:property value="#p.shop_price"/>
											</span>
										</a>
									</li>
							</s:iterator>
						</ul>
				</div>
				<div class="pagination">
					<span>第 <s:property value="pageBean.page"/>/<s:property value="pageBean.totalPage"/> 页</span>
					<s:if test="smallprice != null">
						价格分页
						<s:if test="pageBean.page == 1">
							<span class="firstPage">&nbsp;</span>
							<span class="previousPage">&nbsp;</span>
						</s:if>		
						<s:else>
					     	<!-- 首页 -->
					     	<a href="${pageContext.request.contextPath}/product_findByWay.action?fw=<s:property value="fw"/>&smallprice=<s:property value="smallprice"/>&bigprice=<s:property value="bigprice"/>&page=1" class="firstPage">&nbsp;</a>
							<!-- 上页 -->
					     	<a href="${pageContext.request.contextPath}/product_findByWay.action?fw=<s:property value="fw"/>&smallprice=<s:property value="smallprice"/>&bigprice=<s:property value="bigprice"/>&page=<s:property value="pageBean.page-1"/>" class="previousPage">&nbsp;</a>
					     	<a href="${pageContext.request.contextPath}/product_findByWay.action?fw=<s:property value="fw"/>&smallprice=<s:property value="smallprice"/>&bigprice=<s:property value="bigprice"/>&page=<s:property value="pageBean.page-1"/>"><s:property value="pageBean.page-1"/></a>
						</s:else>
							<span class="currentPage"><s:property value="pageBean.page"/></span>
						<s:if test="pageBean.page == pageBean.totalPage">
							<span class="nextPage">&nbsp;</span>
							<span class="lastPage">&nbsp;</span>
						</s:if>
						<s:else>
					     	<a href="${pageContext.request.contextPath}/product_findByWay.action?fw=<s:property value="fw"/>&smallprice=<s:property value="smallprice"/>&bigprice=<s:property value="bigprice"/>&page=<s:property value="pageBean.page+1"/>"><s:property value="pageBean.page+1"/></a>
							<!-- 下页 -->
					     	<a href="${pageContext.request.contextPath}/product_findByWay.action?fw=<s:property value="fw"/>&smallprice=<s:property value="smallprice"/>&bigprice=<s:property value="bigprice"/>&page=<s:property value="pageBean.page+1"/>" class="nextPage">&nbsp;</a>
							<!-- 尾页 -->
					     	<a href="${pageContext.request.contextPath}/product_findByWay.action?fw=<s:property value="fw"/>&smallprice=<s:property value="smallprice"/>&bigprice=<s:property value="bigprice"/>&page=<s:property value="pageBean.totalPage"/>"  class="lastPage">&nbsp;</a>
						</s:else>
					</s:if>
					<s:if test="fp != null">
						12分页
						<s:if test="pageBean.page == 1">
							<span class="firstPage">&nbsp;</span>
							<span class="previousPage">&nbsp;</span>
						</s:if>		
						<s:else>
					     	<!-- 首页 -->
					     	<a href="${pageContext.request.contextPath}/product_findByWay.action?fw=<s:property value="fw"/>&fp=<s:property value="fp"/>&page=1" class="firstPage">&nbsp;</a>
							<!-- 上页 -->
					     	<a href="${pageContext.request.contextPath}/product_findByWay.action?fw=<s:property value="fw"/>&fp=<s:property value="fp"/>&page=<s:property value="pageBean.page-1"/>" class="previousPage">&nbsp;</a>
					     	<a href="${pageContext.request.contextPath}/product_findByWay.action?fw=<s:property value="fw"/>&fp=<s:property value="fp"/>&page=<s:property value="pageBean.page-1"/>"><s:property value="pageBean.page-1"/></a>
						</s:else>
							<span class="currentPage"><s:property value="pageBean.page"/></span>
						<s:if test="pageBean.page == pageBean.totalPage">
							<span class="nextPage">&nbsp;</span>
							<span class="lastPage">&nbsp;</span>
						</s:if>
						<s:else>
					     	<a href="${pageContext.request.contextPath}/product_findByWay.action?fw=<s:property value="fw"/>&fp=<s:property value="fp"/>&page=<s:property value="pageBean.page+1"/>"><s:property value="pageBean.page+1"/></a>
							<!-- 下页 -->
					     	<a href="${pageContext.request.contextPath}/product_findByWay.action?fw=<s:property value="fw"/>&fp=<s:property value="fp"/>&page=<s:property value="pageBean.page+1"/>" class="nextPage">&nbsp;</a>
							<!-- 尾页 -->
					     	<a href="${pageContext.request.contextPath}/product_findByWay.action?fw=<s:property value="fw"/>&fp=<s:property value="fp"/>&page=<s:property value="pageBean.totalPage"/>"  class="lastPage">&nbsp;</a>
						</s:else>
					</s:if>
					<s:if test="cid != null">
						cid分页
						<s:if test="pageBean.page == 1">
							<span class="firstPage">&nbsp;</span>
							<span class="previousPage">&nbsp;</span>
						</s:if>		
						<s:else>
					     	<!-- 首页 -->
					     	<a href="${pageContext.request.contextPath}/product_findByCid.action?cid=<s:property value="cid"/>&page=1" class="firstPage">&nbsp;</a>
							<!-- 上页 -->
							<a href="${pageContext.request.contextPath}/product_findByCid.action?cid=<s:property value="cid"/>&page=<s:property value="pageBean.page-1"/>" class="previousPage">&nbsp;</a>
							<a href="${pageContext.request.contextPath}/product_findByCid.action?cid=<s:property value="cid"/>&page=<s:property value="pageBean.page-1"/>"><s:property value="pageBean.page-1"/></a>
						</s:else>
							<span class="currentPage"><s:property value="pageBean.page"/></span>
						<s:if test="pageBean.page == pageBean.totalPage">
							<span class="nextPage">&nbsp;</span>
							<span class="lastPage">&nbsp;</span>
						</s:if>
						<s:else>
							<a href="${pageContext.request.contextPath}/product_findByCid.action?cid=<s:property value="cid"/>&page=<s:property value="pageBean.page+1"/>"><s:property value="pageBean.page+1"/></a>
							<!-- 下页 -->
							<a href="${pageContext.request.contextPath}/product_findByCid.action?cid=<s:property value="cid"/>&page=<s:property value="pageBean.page+1"/>" class="nextPage">&nbsp;</a>
							<!-- 尾页 -->
							<a href="${pageContext.request.contextPath}/product_findByCid.action?cid=<s:property value="cid"/>&page=<s:property value="pageBean.totalPage"/>"  class="lastPage">&nbsp;</a>
						</s:else>
					</s:if>
					<s:if test="csid != null">
						csid分页
						<s:if test="pageBean.page == 1">
							<span class="firstPage">&nbsp;</span>
							<span class="previousPage">&nbsp;</span>
						</s:if>
						<s:else>
					     	<!-- 首页 -->
					     	<a href="${pageContext.request.contextPath}/product_findByCsid.action?cid=<s:property value="csid"/>&page=1" class="firstPage">&nbsp;</a>
							<!-- 上页 -->
							<a href="${pageContext.request.contextPath}/product_findByCsid.action?cid=<s:property value="csid"/>&page=<s:property value="pageBean.page-1"/>" class="previousPage">&nbsp;</a>
							<a href="${pageContext.request.contextPath}/product_findByCsid.action?cid=<s:property value="csid"/>&page=<s:property value="pageBean.page-1"/>"><s:property value="pageBean.page-1"/></a>
						</s:else>
							<span class="currentPage"><s:property value="pageBean.page"/></span>
						<s:if test="pageBean.page == pageBean.totalPage">
							<span class="nextPage">&nbsp;</span>
							<span class="lastPage">&nbsp;</span>
						</s:if>
						<s:else>
							<a href="${pageContext.request.contextPath}/product_findByCsid.action?cid=<s:property value="csid"/>&page=<s:property value="pageBean.page+1"/>"><s:property value="pageBean.page+1"/></a>
							<!-- 下页 -->
							<a href="${pageContext.request.contextPath}/product_findByCsid.action?cid=<s:property value="csid"/>&page=<s:property value="pageBean.page+1"/>" class="nextPage">&nbsp;</a>
							<!-- 尾页 -->
							<a href="${pageContext.request.contextPath}/product_findByCsid.action?cid=<s:property value="csid"/>&page=<s:property value="pageBean.totalPage"/>"  class="lastPage">&nbsp;</a>
						</s:else>
					</s:if>
				</div>
			</form>
		</div>
	</div> 
<div class="container footer">
	<div class="span24">
		<div class="footerAd">
					<img src="${pageContext.request.contextPath}/image/footer.jpg" width="950" height="52" alt="我们的优势" title="我们的优势"/>
</div>	</div>
	<div class="span24">
		<ul class="bottomNav">
					<li>
						<a >关于我们</a>
						|
					</li>
					<li>
						<a>联系我们</a>
						|
					</li>
					<li>
						<a >诚聘英才</a>
						|
					</li>
					<li>
						<a >法律声明</a>
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
						<a  target="_blank">配送方式</a>
						|
					</li>
					<li>
						<a >官网</a>
						|
					</li>
					<li>
						<a >论坛</a>
						
					</li>
		</ul>
	</div>
	<div class="span24">
		<div class="copyright">Copyright©2005-2015 网上商城 版权所有</div>
	</div>
</div>
</body></html>