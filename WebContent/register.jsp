<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>

</style>
	
<head>
	<meta charset="UTF-8">
	<title>注册</title>
</head>

<body>
	<canvas class="particle"></canvas>
	<form action="RegisterServlet" method="post">
   		用户名：<input type="text" name="userName"/>
  		密码：<input type="password" name="password"/>
   		<input type="submit" value="注册"/>
  	</form>
</body>
</html>