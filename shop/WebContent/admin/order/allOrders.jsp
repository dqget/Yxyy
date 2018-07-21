<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="${pageContext.request.contextPath}/css/Style1.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/cart.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/product.css" rel="stylesheet" type="text/css" />
		<script language="javascript" src="${pageContext.request.contextPath}/js/public.js"></script>
		<script type="text/javascript">
			function oderDetail(oid){
				
				var but = document.getElementById("but"+oid);
				var div1 = document.getElementById("div"+oid);
				console.log("if but.value");
				if(but.value == "订单详情"){
					// 1.创建异步对象
					var xhr = createXmlHttp();
					// 2.设置监听
					xhr.onreadystatechange = function(){
						if(xhr.readyState == 4){
							if(xhr.status == 200){
								div1.innerHTML = xhr.responseText;
								console.log("xhr.responseText:%s",xhr.responseText);
								console.log("div1.innerHTML:%s",div1.innerHTML);
							}
						}
					}
					// 3.打开连接
					xhr.open("GET","${pageContext.request.contextPath}/adminOrder_findOrderItems.action?oid="+oid+"&time="+new Date().getTime(),true);
					// 4.发送
					xhr.send(null);
					but.value = "关闭";
				}else{
					div1.innerHTML = "";
					but.value="订单详情";
				}
				
			}
			function createXmlHttp(){
				var xmlHttp;
				try{ // Firefox, Opera 8.0+, Safari
					xmlHttp=new XMLHttpRequest();
				}
			    catch (e){
				   try{// Internet Explorer
					   xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
				   }
				   catch (e){
					   try{
						   xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
						}catch (e){
						   
					   }
					}
			    }
				return xmlHttp;
			}
		</script>
	</HEAD>
	<body>
		<br>
		<form id="Form1" name="Form1" action="#" method="post">
			<table cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0">
				<TBODY>
					<tr>
						<td class="ta_01" align="center" bgColor="#afd1f3">
							<strong>订 单 列 表</strong>
						</TD>
					</tr>
					<tr> 
						<td class="ta_01" align="center" bgColor="#f5fafe">
							<table cellspacing="0" cellpadding="1" rules="all"
								bordercolor="gray" border="1" id="DataGrid1"
								style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
								<tr
									style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

									<td align="center" width="5%">
										序号
									</td>
									<td align="center" width="5%">
										订单编号
									</td>
									<td align="center" width="5%">
										用户名称
									</td>
									<td align="center" width="5%">
										订单总价格
									</td>
									<td align="center" width="5%">
										订单状态
									</td>
									<td align="center" width="10%">
										订单时间
									</td>
									<td align="center" width="5%">
										收货人
									</td>
									<td align="center" width="10%">
										收货电话
									</td>
									<td align="center" width="10%">
										收货地址
									</td>
									<td width="40%" align="center">
										订单详情
									</td>
								</tr>
								<s:iterator var="order" value="pageBean.list" status="status">
										<tr onmouseover="this.style.backgroundColor = 'white'"
											onmouseout="this.style.backgroundColor = '#F5FAFE';">
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="5%">
												<s:property value="#status.count"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="5%">
												<s:property value="#order.oid"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="5%">
												<s:property value="#order.user.userName"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="5%">
												<s:property value="#order.total"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="5%">
												<s:if test="1==#order.state"><font color="red">订单未付款</font></s:if>
												<s:elseif test="2==#order.state"><a href="${pageContext.request.contextPath}/adminOrder_sendGoods.action?oid=<s:property value="#order.oid"/>"><font color="blue">订单已经付款</font></a></s:elseif>
												<s:elseif test="3==#order.state"><font color="cyan">已经发货</font> </s:elseif>
												<s:elseif test="4==#order.state"><font color="green">订单交易完成</font></s:elseif>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="10%">
												<s:property value="#order.ordertime"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="5%">
												<s:property value="#order.name"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="10%">
												<s:property value="#order.phone"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="10%">
												<s:property value="#order.addr"/>
											</td>
											<td align="center" width="40%" style="HEIGHT: 22px">
												<input type="button" value="订单详情" id="but<s:property value="#order.oid"/>" onclick="oderDetail(<s:property value="#order.oid"/>)"/>
												<div id="div<s:property value="#order.oid"/>">
													
												</div>
											</td>
										</tr>
									</s:iterator>	
							</table>
						</td>
					</tr>
					<!-- 分页查询  -->
					<span>第 <s:property value="pageBean.page"/>/<s:property value="pageBean.totalPage"/> 页</span>
					<s:if test="pageBean.page == 1">
						<span class="firstPage">&nbsp;</span>
						<span class="previousPage">&nbsp;</span>
					</s:if>
					<s:else>
				     	<!-- 首页 -->
				     	<a href="${pageContext.request.contextPath}/adminOrder_findAllByPage.action?page=1" class="firstPage">   首页   </a>
						<!-- 上页 -->
						<a href="${pageContext.request.contextPath}/adminOrder_findAllByPage.action?page=<s:property value="pageBean.page-1"/>" class="previousPage">   上一页   </a>
						<a href="${pageContext.request.contextPath}/adminOrder_findAllByPage.action?page=<s:property value="pageBean.page-1"/>">   <s:property value="pageBean.page-1"/>   </a>
					</s:else>
						<span class="currentPage"><s:property value="pageBean.page"/></span>
					<s:if test="pageBean.page == pageBean.totalPage">
						<span class="nextPage">&nbsp;</span>
						<span class="lastPage">&nbsp;</span>
					</s:if>
					<s:else>
						<a href="${pageContext.request.contextPath}/adminOrder_findAllByPage?page=<s:property value="pageBean.page+1"/>">   <s:property value="pageBean.page+1"/>   </a>
						<!-- 下页 -->
						<a href="${pageContext.request.contextPath}/adminOrder_findAllByPage?page=<s:property value="pageBean.page+1"/>" class="nextPage">   下一页   </a>
						<!-- 尾页 -->
						<a href="${pageContext.request.contextPath}/adminOrder_findAllByPage?page=<s:property value="pageBean.totalPage"/>"  class="lastPage">   尾页   </a>
					</s:else>
				</TBODY>
			</table>
		</form>
	</body>
</HTML>

