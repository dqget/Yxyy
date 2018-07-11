<?xml version="1.0" encoding="utf-8" ?>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style type="text/css">@font-face {
	font-family: 'Font4Code';
	src: url('../fonts/Font4Code.ttf');
}

* {
	margin: 0;
	padding: 0;
	font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
}

body {
	background-color: #ede;
}

i {
	font-family: Font4Code;
	font-size: 1.2em;
	font-style: normal;
	cursor: pointer;
}

header {
	height: 50px;
}

h1 {
	position: fixed;
	padding: 14px 15px;
	color: 	#000000;
	font-size: 28px;
	font-weight: bolder;
	text-align: center;
}

header ul {
	font-size: 0;
	float: right;
}

header li {
	display: inline-block;
}

header input {
	float: right;
	margin: 8px 15px;
	padding: 8px 12px;
	font-size: 14px;
	color: #555;
	border: 1px solid #ccc;
	border-radius: 4px;
	-webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
	box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
	-webkit-transition: border-color ease-in-out .15s, -webkit-box-shadow
		ease-in-out .15s;
	transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s;
	box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
	-webkit-transition: border-color ease-in-out .15s, -webkit-box-shadow
		ease-in-out .15s;
}

header input:focus {
	border-color: #66afe9;
	outline: none;
	-webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075), 0 0 8px
		rgba(102, 175, 233, .6);
	box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075), 0 0 8px
		rgba(102, 175, 233, .6);
}

header input::-moz-placeholder {
	color: #999;
	opacity: 1;
}

header input:-ms-input-placeholder {
	color: #999
}

header input::-webkit-input-placeholder {
	color: #999
}

a {
	color: #7a33b7;
	font-size: 14px;
	text-decoration: none;
}

header a {
	display: inline-block;
	padding: 17px 15px;
}

header a:hover {
	background-color: #eee;
}

header li:nth-child(1) i::before {
	content: "7"
}

header li:nth-child(2) i::before {
	content: "8"
}

header li:nth-child(3) i::before {
	content: "9"
}

aside a {
	display: block;
	padding: 12px 20px;
}

header a:focus, header a:hover, aside a:hover {
	color: #52237c;
}

aside .active a {
	background-color: #ceafe9;
	color: #fff;
}

aside {
	position: fixed;
	top: 51px;
	bottom: 0;
	padding: 20px 0;
	width: 16.66666667%;
	overflow-y: auto;
	background-color: #b383dd;
	border-right: 1px solid #eee;
}

aside ul {
	margin-bottom: 20px;
	list-style: none;
}

aside i::before {
	font-size: 21px;
	content: "6"
}

article {
	box-sizing: border-box;
	margin-left: 16.66666667%;
	padding: 39px 50px;
    overflow-x: auto;
    min-height: 89vh;
    width: 83%;
	background-color: #ceafe9;
}

article p {
	text-align: center;
}

article a {
	margin: 2px;
	padding: 4px;
	border: 1px solid #7a33b7;
	color: #333;
}

h2 {
	margin-bottom: 11px;
	padding-bottom: 8px;
	border-bottom: 1px solid #eee;
	color: #333;
	font-size: 30px;
	font-weight: normal;
}

table {
	margin-bottom: 20px;
	width: 100%;
	color: #333;
	border-collapse: collapse;
}

thead {
	border-bottom: 2px solid #ddd;
}

th {
	white-space: nowrap;
	padding: 9px 8px;
	text-align: left;
	vertical-align: bottom;
}

tbody tr {
	border-top: 1px solid #ddd;
}

td {
	white-space: nowrap;
	padding: 12px 8px;
	vertical-align: top;
}

tbody tr:nth-of-type(odd) {
	background-color: #e6d7f4;
}

tbody .active:nth-child(n) {
	background: #eef;
}

tbody tr:hover {
	background-color: #ede;
}

tbody i::before {
	content: "1";
}

tbody i:last-child::before {
	content: "3";
}

tbody .change::before {
	content: "2";
}

dialog {
	position: fixed;
	top: 0;
	margin: 30px auto;
	padding: 14px;
	width: 570px;
	background-color: #fff;
	border: 1px solid #999;
	border-radius: 6px;
	font-size: 14px;
	color: #333;
	-webkit-box-shadow: 0 5px 15px rgba(0, 0, 0, .5);
	box-shadow: 0 5px 15px rgba(0, 0, 0, .5);
}

dialog h3 {
	padding: 17px 15px 0px 15px;
	font-weight: normal;
	font-size: 18px;
}

dialog p {
	margin: 16px 0;
	padding: 29px 15px;
	border-bottom: 1px solid #e5e5e5;
	border-top: 1px solid #e5e5e5;
}

dialog span {
	display: block;
}

dialog i::before {
	padding: 5px;
	content: "4";
}

dialog .choosed::before {
	content: "5";
}

dialog a {
	padding: 15px 15px 0 0;
	font-size: 21px;
	font-weight: bold;
	opacity: .2;
	cursor: pointer;
	float: right;
	color: buttontext;
}

dialog button {
	margin: 1px 15px 15px 9px;
	padding: 8px 12px;
	font-size: 14px;
	cursor: pointer;
	border: 1px solid #204d74;
	border-radius: 4px;
	-webkit-box-shadow: inset 0 1px 0 rgba(255, 255, 255, .15), 0 1px 1px
		rgba(0, 0, 0, .075);
	box-shadow: inset 0 1px 0 rgba(255, 255, 255, .15), 0 1px 1px
		rgba(0, 0, 0, .075);
	background-repeat: repeat-x;
	color: #fff;
	background-image: linear-gradient(to bottom, #7a33b7 0, #265a88 100%);
	background-color: #265a88;
	background-position: 0 -15px;
	text-shadow: 0 -1px 0 rgba(0, 0, 0, .2);
	float: right;
}

dialog button:last-child {
	margin: 1px 0 15px 0px;
	background-image: linear-gradient(to bottom, #fff 0, #e0e0e0 100%);
	border-color: #adadad;
	background-color: #e0e0e0;
	color: #333;
	text-shadow: 0 1px 0 #fff;
}</style>
</head>
<body>
<h1>标题</h1><br><br><br>
	<jsp:useBean id="orderBean" class="bean.OrderBean"></jsp:useBean>
	<c:set var="rid" value="${param.rid }" />
	<c:set var="cid" value="${param.cid }" />
	<c:set var="oname" value="${param.oname }" />
	<c:set var="phone" value="${param.phone }" />
	<c:set var="starttime" value="${param.starttime }" />
	<c:set var="endtime" value="${param.endtime }" />
	<jsp:useBean id="order" class="bean.OrderBean"></jsp:useBean>
	<jsp:setProperty property="*" name="order" />
	<c:catch var="e">
${orderBean.orderRoom(order) }
		<c:redirect url="Order.jsp">
		</c:redirect>
	</c:catch>
	${e.message}
</body>
</html>