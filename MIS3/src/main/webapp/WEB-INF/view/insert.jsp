<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>创建信息</title>
<link rel="stylesheet" href="/MIS3/views/css/business.css" />
 <script type="text/javascript" src="/MIS3/views/jq/jquery-1.11.3.min.js"></script> 
</head>
<script type="text/javascript">
function queryNumber(){
	var number = document.getElementsByName("number")[0].value;
	if(number==""){
		document.getElementsByName("tips")[0].innerHTML="<font color='red'>"+"工号不能为空！"+"</font>"
	}else{
		document.getElementsByName("tips")[0].innerHTML="<font color='red'>"+""+"</font>"
		$.ajax({
 			url:"/MIS3/QueryNumber",//请求地址
 			async:true,//是否异步
 		    type:"POST",//提交方式
 		    data:{            //参数体
 		    	"number":number,
 		    },
 		    success:function(data){ //成功响应
 		       if(data[0].num>0){
 		    		document.getElementsByName("tips")[0].innerHTML="<font color='red'>"+"工号已存在！"+"</font>";
 		    	
 		       }
 		       else{
 		    		document.getElementsByName("tips")[0].innerHTML="<font color='green'>"+"工号可用！"+"</font>"
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
<br />
<br />
<br />
<br />
<br />


	<form action="/MIS3/insertOne" method="post">
<table border="2" width="1820" align="center" id="tbl">
		<thead height="50" style="font-size: 22px;">

			<th style="color: black;width:300px; ">工号</th>
			<th style="color: black;width:300px;">姓名</th>
			<th style="color: black;width:300px;">身份证</th>
			<th style="color: black;width:300px;">性别</th>
			

		</thead>
		<tbody>	
				<tr>
					<span name="tips" style="font-size:50px;text-align:center;"> </span>
					<td align="center"><input type="text" name="number" style="font-size: 22px;width:300px;" onblur="queryNumber()"/></td>
					<td align="center"><input type="text" name="name"  style="font-size: 22px;width:300px;"/></td>
					<td align="center"><input type="text" name="idCard"  style="font-size: 22px;width:300px;"/></td>
					<td align="center"><input type="text" name="sex"  style="font-size: 22px;width:300px;"/></td>
					
				
</tr>
		</tbody>
	</table>
	
<table border="2" width="1820" align="center" id="tbl" style="font-size: 22px;">
		<thead height="50">
		    <th style="color: black;width:300px;">年龄</th>
			<th style="color: black;width:300px;">出身日期</th>
			<th style="color: black;width:300px;">学历</th>
			<th style="color: black;width:300px;">籍贯</th>
			
		</thead>
		<tbody>	
				<tr >
				    <td align="center"><input type="text" name="age"  style="font-size: 22px;width:300px;"/></td>
					<td align="center"><input type="date" name="bir"  style="font-size: 22px;width:300px;"/></td>
					<td align="center"><input type="text" name="education"  style="font-size: 22px;width:300px;"/></td>
					<td align="center"><input type="text" name="nativePlace"  style="font-size: 22px;width:300px;"/></td>
					
</tr>
		</tbody>
		
<table border="2" width="1820" align="center" id="tbl" style="font-size: 22px;">
		<thead height="50">
		 <th style="color: black;width:300px;">部门</th>
			<th style="color: black;width:300px;">岗位</th>
			<th style="color: black;width:300px;">等级</th>
			<th style="color: black;width:300px;">婚姻</th>

			
		</thead>
		<tbody>	
				<tr >
				    <td align="center"><input type="text" name="department"  style="font-size: 22px;width:300px;"/></td>
					<td align="center"><input type="text" name="post"  style="font-size: 22px;width:300px;"/></td>
					<td align="center"><input type="text" name="grade"  style="font-size: 22px;width:300px;"/></td>
					<td align="center"><input type="text" name="marriage"  style="font-size: 22px;width:300px;" /></td>
					
</tr>
		</tbody>		
		
		
		
	</table>	
	<table border="2" width="1820" align="center" id="tbl" style="font-size: 22px;">
		<thead height="50">

			<th style="color: black;width:300px;">联系方式</th>
			<th style="color: black;width:300px;">家庭地址</th>
			<th style="color: black;width:300px;">入岗时间</th>
			<th style="color: black;width:300px;"></th>
		</thead>
		<tbody>	
				<tr >
				   
					<td align="center"><input type="text" name="phone"  style="font-size: 22px;width:300px;"/></td>
					<td align="center"><input type="text" name="addr"  style="font-size: 22px;width:300px;"/></td>
					<td align="center"><input type="date" name="entryTime"  style="font-size: 22px;width:300px;"/></td>
					<td align="center"></td>
</tr>
		</tbody>		
		
		
		
	</table>	
	
	<br />
	<br />
 	<br />
 	<div align="center"> 	
   <input   type="submit" value="创建" style="font-size: 22px; height: 40px; width: 150px; display: inline-block;"> 
 	</div>
	</form>		
</body>
</html>