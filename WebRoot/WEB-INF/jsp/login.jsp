<%@ page	 language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>登录</title>
	
	<script type="text/javascript">
	
		function formSubmit()
		{
			
			var btn = document.getElementById("submitBtn") ;
			btn.disabled = true ;
			document.getElementById("login").submit();
		}
		
	</script>
  </head>
  
  <body>	
  	<table>
  		<form  id = "login" action = "${pageContext.request.contextPath}/servlet/LoginServlet" method = "post">
  			<tr>
  				<td>用户名：</td>
  				<td><input type = "text" name = "username"></td>
  			</tr>
  			<tr>
  				<td>密码：</td>
  				<td><input type = "password" name = "password"></td>
  				
  			</tr>
  			<tr>
  				<!-- <td><input type = "submit" value = "登录"></td>
  				<td><input type = "reset" value = "重置"></td> -->
  				<td><input id = "submitBtn" type = "button" value= "登录" onclick = "formSubmit()"></td>
  				<td><input type = "button" value= "注册"></td>
  			</tr>
  		</form>
  	</table>
  </body>
</html>
