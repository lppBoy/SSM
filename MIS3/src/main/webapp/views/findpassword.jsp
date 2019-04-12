<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>找回密码</title>
<link rel="stylesheet" href="/MIS3/views/css/findpassword.css" />
 <script type="text/javascript" src="/MIS3/views/jq/jquery-1.11.3.min.js"></script>
</head>
<script type="text/javascript">
function send(){
	
	var rootname = document.getElementById("rootname").value;
	var password = document.getElementById("password").value;
	var password1 = document.getElementById("password1").value;
	if(rootname==""||password==""||password1==""||password!=password1){
		alert("信息不完整！");
}else{
	$.ajax({
		url:"/MIS3/sendMsg",//请求地址
		async:true,//是否异步
	    type:"POST",//提交方式
	    data:{            //参数体
	    	"rootname":rootname,
	    },
	    success:function(data){ //成功响应
	    	 	if(data.num==0){
	    	 		alert("用户不存在！");
	    	 	}else if(data.num==1){
	    	 		alert("邮件已发送！");
	    	 	}
	      },
	    error:function(){  //错误响应
	    	alert("ERROR");
	    },
	   dataType:"json"  //接收类型
	});
}

}


function update(){
	var rootname = document.getElementById("rootname").value;
	var password = document.getElementById("password").value;
	var VerificationCode = document.getElementById("VerificationCode").value;
	if(VerificationCode==""){
		alert("验证码不能为空！");
	}else{
		$.ajax({
			url:"/MIS3/inspectMsg",//请求地址
			async:true,//是否异步
		    type:"POST",//提交方式
		    data:{            //参数体
		    	"VerificationCode":VerificationCode,
		    },
		    success:function(data){ //成功响应
		    	 	if(data[0].num==0){
		    	 		alert("验证码错误！");
		    	 	}else if(data[0].num==1){
		    	 		location.href = "${pageContext.request.contextPath}/updateInfo?rootname=" + rootname +"&password="+
		    	 		password; 
		    	 	}
		      },
		    error:function(){  //错误响应
		    	alert("ERROR");
		    },
		   dataType:"json"  //接收类型
		});
	}
	
}
</script>
<body>
<div id="option1">
账户：<br/><br/>
新密码：<br/><br/>
确认密码：<br/><br/>
验证码：<br/><br/>
</div>
<div id="option2">
<input type="text";      id="rootname";	        style="width: 210px; height: 34px; font-size:18px;" /><br/><br/>
<input type="password";  id="password";         style="width: 210px; height: 34px;font-size:18px;" /><br/><br/>
<input type="password";  id="password1";        style="width: 210px; height: 34px;font-size:18px;"/><br/><br/>
<input type="text";      id="VerificationCode"; style="width: 210px; height: 34px;font-size:18px;"/><br/><br/>
</div>
<div id="option4"">
<input type="button"; id="send"; value="发送邮箱验证码"; 	style="width: 200px; height: 40px; font-size:18px; margin-left: 64px;margin-top:160px" onclick="send()";/><br/><br/>
</div>
<div id="option5"">
<input type="button"; id="send"; value="确认修改"; 	style="width: 200px; height: 40px; font-size:18px; margin-left: 64px;margin-top:1px" onclick="update()";/><br/><br/>
</div>
</body>
</html>