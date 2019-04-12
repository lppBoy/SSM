
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
			window.onload=function(){
				var temp = 5;
			  var time =document.getElementById("time");
			     var timer  = setInterval(function(){
			    	temp--;
			    	time.innerHTML=temp;
			    	if(temp==0){
			    		clearInterval(timer);
			    		location.href="views/index.jsp";
			    	}
			    },1000);
			}
		</script>
</head>
<body>
操作成功！<span id="time"style="color: red" >5</span>秒后跳转，如不跳转请点击<a href="views/index.jsp">这里</a>!
</body>
</html>