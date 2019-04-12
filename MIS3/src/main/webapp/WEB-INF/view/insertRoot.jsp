<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加管理员</title>
<link rel="stylesheet" href="/MIS3/views/css/insertRoot.css" />
 <script type="text/javascript" src="/MIS3/views/jq/jquery-1.11.3.min.js"></script> 
<script type="text/javascript">
function yanzheng(){
	var secretkey = document.getElementById("secretkey").value;
	
	if(secretkey==""){
		alert("请输入密钥");
	}
	else {
		$.ajax({
 			url:"/MIS3/Secret11",//请求地址
 			async:true,//是否异步
 		    type:"POST",//提交方式
 		    data:{            //参数体
 		    	"secretkey":secretkey,
 		    },
 		    success:function(data){ //成功响应
 		       if(data[0].num==1){
 		    	  document.getElementById("option5").style.display="block";
 		    	  document.getElementById("option4").style.display="block";
 		       }
 		       else{
 		    	  alert("验证失败！");
 		       }
 		    },
 		    error:function(){  //错误响应
 		    	alert("ERROR");
 		    },
 		   dataType:"json"  //接收类型
 		});
	
	}

}

function send(){
	var mailbox = document.getElementById("mailbox").value;
	if(mailbox==""){
		alert("邮箱为空！");
}else{
	$.ajax({
			url:"/MIS3/send",//请求地址
			async:true,//是否异步
		    type:"POST",//提交方式
		    data:{            //参数体
		    	"mailbox":mailbox,
		    },
		    success:function(data){ //成功响应
		    	 	alert("邮件正在发送中，请注意查看！");	   
		      },
		    error:function(){  //错误响应
		    	alert("ERROR");
		    },
		   dataType:"json"  //接收类型
		});
}
}

function login(){
	var VerificationCode = document.getElementById("VerificationCode").value;
	if(VerificationCode==""){
		alert("验证码为空！");
}
	else{
		
		$.ajax({
			url:"/MIS3/login1",//请求地址
			async:true,//是否异步
		    type:"POST",//提交方式
		    data:{            //参数体
		    	"VerificationCode":VerificationCode,
		    },
		    success:function(data){ //成功响应
		    	 		 
		    if(data[0].code==0){
		    	alert("验证码错误！");
		    }
		    else if(data[0].code==1){
		    	
		    	var rootname = document.getElementById("rootname").value;
		    	var password = document.getElementById("password").value;
		    	var password1 = document.getElementById("password1").value;
		    	var mailbox = document.getElementById("mailbox").value;
		    	if(rootname==""||password==""||password1==""||password!=password1){
		    		alert("注册信息不完整或者两次密码不相等！");
		    	} else{
		    		location.href = "loginMain?rootname=" + rootname +"&password="+
		    		password+"&mailbox="+mailbox; 
		    		 
		    	} 
		    	
		    }
		      },
		    error:function(){  //错误响应
		    	alert("ERROR");
		    },
		   dataType:"json"  //接收类型
		});
		
	}
		
}

function mimayanzheng(){
	var password =  document.getElementById("password").value;
	var password1 =  document.getElementById("password1").value;
	if(password!=password1){
		 alert("两次输入密码不一致！");
	}
}
 
 function nameyanzheng(){
	var rootname =  document.getElementById("rootname").value;
	 if(rootname==""){
		 alert("用户名必填！");
	 }else{
			$.ajax({
				url:"/MIS3/nameyanzheng",//请求地址
				async:true,//是否异步
			    type:"POST",//提交方式
			    data:{            //参数体
			    	"rootname":rootname,
			    },
			    success:function(data){ //成功响应
			    	   if(data[0].num==1){
			    		   alert("此用户已存在！")
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

</head>
<body>

<div id="option1">
账户：<br/><br/>
密码：<br/><br/>
确认密码：<br/><br/>
密钥:<br/><br/>
邮箱：<br/><br/>
验证码：<br/><br/>
</div>
<div id="option2">
<input type="text";      id="rootname";	        style="width: 210px; height: 34px; font-size:18px;" onblur="nameyanzheng()" /><br/><br/>
<input type="password";  id="password";         style="width: 210px; height: 34px;font-size:18px;" /><br/><br/>
<input type="password";  id="password1";        style="width: 210px; height: 34px;font-size:18px;" onblur="mimayanzheng()"/><br/><br/>
<input type="password";  id="secretkey";        style="width: 210px; height: 34px;font-size:18px;"/><br/><br/>
<input type="text";      id="mailbox";          style="width: 210px; height: 34px;font-size:18px;"/><br/><br/>
<input type="text";      id="VerificationCode"; style="width: 210px; height: 34px;font-size:18px;"/><br/><br/>
</div>
<div id="option3">
<input type="button"; value="密钥验证"; style="width: 200px; height: 40px; font-size:18px; margin-left: 64px;margin-top: 242px";  onclick="yanzheng()"; /><br/><br/>
</div>
<div id="option4"; style="display: none">
<input type="button"; id="send"; value="发送验证码"; 	style="width: 200px; height: 40px; font-size:18px; margin-left: 64px;" onclick="send()";/><br/><br/>
</div>
<div id="option5"; style="display:none;      margin-left: 1010px;">
<input type="button"; id="buttonm" value="注册"; style="font-size:18px; width: 200px; height: 40px; " onclick="login()";/><br/><br/>
</div>
</body>
</html>