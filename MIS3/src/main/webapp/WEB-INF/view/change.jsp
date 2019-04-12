<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>修改信息</title>
<link rel="stylesheet" href="/MIS3/views/css/business.css" />
</head>
<body>
<br />
<br />
<br />
<br />
<br />


	<form action="/MIS3/change" method="post">
<table border="2" width="1820" align="center" id="tbl">
		<thead height="50" style="font-size: 22px;">
			<th style="color: black;width:300px;">id</th>
			<th style="color: black;width:300px;">工号</th>
			<th style="color: black;width:300px;">姓名</th>
			<th style="color: black;width:300px;">身份证</th>
			

		</thead>
		<tbody>	
				<tr>
					<td align="center"><input type="text" name="id" value="${employee.id}" style="font-size: 22px;width:300px;"/></td>
					<td align="center"><input type="text" name="number" value="${employee.number}" style="font-size: 22px;width:300px;" /></td>
					<td align="center"><input type="text" name="name" value="${employee.name}" style="font-size: 22px;width:300px;"/></td>
					<td align="center"><input type="text" name="idCard" value="${employee.idCard}" style="font-size: 22px;width:300px;"/></td>
					
				
</tr>
		</tbody>
	</table>
	
<table border="2" width="1820" align="center" id="tbl" style="font-size: 22px;">
		<thead height="50">
		    <th style="color: black;width:300px;">性别</th>
			<th style="color: black;width:300px;">年龄</th>
			<th style="color: black;width:300px;">出身日期</th>
			<th style="color: black;width:300px;">学历</th>

		</thead>
		<tbody>	
				<tr >
				   <td align="center"><input type="text" name="sex" value="${employee.sex}" style="font-size: 22px;width:300px;"/></td>
					<td align="center"><input type="text" name="age" value="${employee.age}" style="font-size: 22px;width:300px;"/></td>
					<td align="center"><input type="date" name="bir" value="${employee.bir}" style="font-size: 22px;width:300px;"/></td>
					<td align="center"><input type="text" name="education" value="${employee.education}" style="font-size: 22px;width:300px;"/></td>
					
</tr>
		</tbody>
	</table>	
	
	
	
	
	
	
	<table border="2" width="1820" align="center" id="tbl" style="font-size: 22px;">
		<thead height="50">
		  
			<th style="color: black;width:300px;">籍贯</th>
			<th style="color: black;width:300px;">部门</th>
			<th style="color: black;width:300px;">岗位</th>
			<th style="color: black;width:300px;">等级</th>
		
		</thead>
		<tbody>	
				<tr >
				   
					<td align="center"><input type="text" name="nativePlace" value="${employee.nativePlace}" style="font-size: 22px;width:300px;"/></td>
					<td align="center"><input type="text" name="department" value="${employee.department}" style="font-size: 22px;width:300px;"/></td>
					<td align="center"><input type="text" name="post" value="${employee.post}" style="font-size: 22px;width:300px;"/></td>
					<td align="center"><input type="text" name="grade" value="${employee.grade}" style="font-size: 22px;width:300px;"/></td>
					
</tr>
		</tbody>
	</table>	
	
	
	<table border="2" width="1820" align="center" id="tbl" style="font-size: 22px;">
		<thead height="50">
		  

			<th style="color: black;width:300px;">婚姻</th>
			<th style="color: black;width:300px;">联系方式</th>
			<th style="color: black;width:300px;">家庭地址</th>
			<th style="color: black;width:300px;">入岗时间</th>
		</thead>
		<tbody>	
				<tr >
				   
					
					<td align="center"><input type="text" name="marriage" value="${employee.marriage}" style="font-size: 22px;width:300px;" /></td>
					<td align="center"><input type="text" name="phone" value="${employee.phone}" style="font-size: 22px;width:300px;"/></td>
					<td align="center"><input type="text" name="addr" value="${employee.addr}" style="font-size: 22px;width:300px;"/></td>
					<td align="center"><input type="date" name="entryTime" value="${employee.entryTime}" style="font-size: 22px;width:300px;"/></td>
</tr>
		</tbody>
	</table>		
	
	<br />
	<br />
 	<br />
 	<div align="center"> 	
   <input   type="submit" value="修改" style="font-size: 22px; height: 40px; width: 150px; display: inline-block;"> 
 	</div>
	</form>		
</body>
</html>