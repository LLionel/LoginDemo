<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    <title>My JSP 'index.jsp' starting page</title>
	
  </head>
  
  <body>
  	<h3 style="text-align:center">XXXXX网站</h3>
  	<br/>
  	<br/>
  	
  	<div style ="text-align : right">
  	
	  	<c:if test="${ user!=null}">
		  欢迎您 ： ${user.nickname } <a href = "${pageContext.request.contextPath}/servlet/LogoutServlet">注销</a>
		</c:if>
		<c:if test="${user==null }">
			<a href = "${pageContext.request.contextPath}/servlet/LoginUIServlet">登录</a>
			<a href = "${pageContext.request.contextPath}/servlet/RegisterUIServlet">注册</a>
		</c:if>
  	
  	</div>
	  
	<hr>
  </body>
</html>
