<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    isELIgnored="false"
    %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%
  request.setCharacterEncoding("utf-8");
%>

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width">
	<style>
		#container {
			width: 100%;
			margin: 0px auto;
			text-align:center;
			border: 0px solid #bcbcbc;
		}
		#header {
			padding: 5px;
			margin-bottom: 5px;
			border: 0px solid #bcbcbc;
			background-color: lightgreen;
		}
		#quick {
			width: 15%;
			height:400px;
			padding: 5px;
			margin-right: 5px;
			margin-bottom: 5px;
			float: right;
			background-color: yellow;
			border: 0px solid #bcbcbc;
			font-size:10px;
		}
		#content {
			width: 75%;
			padding: 5px;
			margin-right: 5px;
			float: left;
			border: 0px solid #bcbcbc;
		}
		#footer {
			clear: both;
			padding: 5px;
			border: 0px solid #bcbcbc;
			background-color: lightblue;
		}

	</style>


	<title><tiles:insertAttribute name="title" /></title>
	
</head>
<body>
<div id="container">
	<div id="header">
		<tiles:insertAttribute name="header"/>
	</div>
	<div id="quick">
		<tiles:insertAttribute name="quickMenu"/>
	</div>
	<div id="content">
		<tiles:insertAttribute name="body"/>
	</div>
	<div id="footer">
		<tiles:insertAttribute name="footer"/>
	</div>
</div>
</body>      
        
        