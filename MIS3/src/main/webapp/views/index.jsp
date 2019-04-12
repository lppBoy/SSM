<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>人事信息管理系统</title>
 <audio autoplay="autoplay" controls="controls"loop="loop" preload="auto"
            	src="/MIS3/views/music/DNF.mp3">
      		
</audio> 
<link rel="stylesheet" href="/MIS3/views/css/index.css" />
</head>
<body>
	<form action="/MIS3/landController" method="post">
		<div id="main">
			<input type="text" name="rootname"
				style="font-size: 22px; height: 30px; width: 150px; display: inline-block;" /><br />
			<br /> <input type="password" name="password"
				style="font-size: 22px; height: 30px; width: 150px; display: inline-block;" /><br />
			<span style="color: red">${msg}</span>
		</div>
		<div id="main-1">
			<input type="submit" value="登陆"
				style="font-size: 22px; height: 60px; width: 335px; display: inline-block;" />
		</div>
	</form>
	      <div id="main-2" style="margin-left: 762px">
	      <a href="/MIS3/insertRoot"><input type="button" value="添加超级管理员账户"
				style="font-size: 22px; height: 60px; width: 335px; display: inline-block;" /></a><br/>
				<a href="findpassword.jsp"> <input type="button" value="找回密码"
				style="font-size: 22px; height: 60px; width: 335px; display: inline-block;" /></a>
	      </div>
	      
	     
	     
	   
		
</body>
</html>