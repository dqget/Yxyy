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
	</HEAD>
	<body>
		<br>
		<form id="Form1" name="Form1" action="${pageContext.request.contextPath}/user/list.jsp" method="post">
			<table cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0">
				<TBODY>
					<tr>
						<td class="ta_01" align="center" bgColor="#afd1f3">
							<strong>用 户 列 表</strong>
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
										用户编号
									</td>
									<td align="center" width="5%">
										用户名
									</td>
									<td align="center" width="15%">
										邮箱
									</td>
									<td align="center" width="8%">
										电话
									</td>
									<td align="center" width="10%">
										地址
									</td>
									<td align="center" width="10%">
										消费金额
									</td>
									<td align="center" width="10%">
										折扣
									</td>
									<td width="10%" align="center">
										删除
									</td>
								</tr>
								<s:iterator var="u" value="uList" status="status">
										<tr onmouseover="this.style.backgroundColor = 'white'"
											onmouseout="this.style.backgroundColor = '#F5FAFE';">
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="5%">
												<s:property value="#status.count"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="5%">
												<s:property value="#u.uid"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="5%">
												<s:property value="#u.userName"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="15%">
												<s:property value="#u.email"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="8%">
												<s:property value="#u.phone"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="10%">
												<s:property value="#u.addr"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="10%">
												<s:property value="#u.monetary"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="10%">
												<s:property value="#u.discount"/>
											</td>
											<td align="center" style="HEIGHT: 22px">
												<a href="${pageContext.request.contextPath}/adminUser_delete.action?uid=<s:property value="#u.uid"/>">
													<img src="${pageContext.request.contextPath}/images/i_del.gif" width="16" height="16" border="0" style="CURSOR: hand">
												</a>
											</td>
										</tr>
								</s:iterator>	
							</table>
						</td>
					</tr>
				</TBODY>
			</table>
		</form>
	</body>
</HTML>

