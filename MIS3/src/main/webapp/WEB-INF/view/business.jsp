<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理界面</title>
<link rel="stylesheet" href="/MIS3/views/css/business.css" />
<script type="text/javascript">


    function deleteOne(id){
	var isDel = confirm("确认删除?");
	if (isDel) {
		location.href = "/MIS3/deleteOne?code=" + id;
	}
	
    }
	function change(id){
	

			location.href = "/MIS3/changeOrInsert?code=" + id;
	
}
	
	function insert(){
        id=0;
		location.href = "/MIS3/changeOrInsert?code=" + id;

}
</script>
</head>
<body>
	<div id="id" style="font-size: 30px;">
		&nbsp; &nbsp; 当前用户：【<shiro:principal></shiro:principal>】 &nbsp; &nbsp; &nbsp; 
		<a href="/MIS3/logout">注销</a>
	</div>
	<br />
	<br />
	<br />
	<br />
	<form action="/MIS3/query" method="post">
		<div id="query" align="center"
			style="width: 1305px; font-size: 26px; background: slategray;">
			工号： <input type="text" name="number"
				style="width: 180px; font-size: 26px;"> 姓名：<input
				type="text" name="name" style="width: 120px; font-size:26px;">
			身份证号： <input type="text" name="idCard" style="font-size:26px;">
			性别： <select name="sex" style="font-size: 26px;">
				<option value="0" style="font-size: 26px;">请选择</option>
				<option value="1" style="font-size: 26px;">男</option>
				<option value="2" style="font-size: 26px;">女</option>
			</select> &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; <input type="submit"
				value="查询" style="font-size: 26px;">
		</div>

	</form>
	<br />
	<br />
	<input type="button" value="新增员工信息"
		style="font-size: 22px;  height: 40px; width: 180px; display: inline-block;"
		onclick="insert()" />
	<br />
	<br />

	<table border="2" width="1920" align="center" id="tbl">
		<thead height="50">
			<th style="color: black">id</th>
			<th style="color: black">工号</th>
			<th style="color: black">姓名</th>
			<th style="color: black">身份证</th>
			<th style="color: black">性别</th>
			<th style="color: black">年龄</th>
			<th style="color: black">出身日期</th>
			<th style="color: black">学历</th>
			<th style="color: black">籍贯</th>
			<th style="color: black">部门</th>
			<th style="color: black">岗位</th>
			<th style="color: black">等级</th>
			<th style="color: black">婚姻</th>
			<th style="color: black">联系方式</th>
			<th style="color: black">家庭地址</th>
			<th style="color: black">入岗时间</th>
			<th style="color: black">编辑</th>
		</thead>
		<tbody>
			<c:forEach items="${employee.productList}" var="e" varStatus="idx">

				<tr>

					<td align="center">${e.id}</td>
					<td align="center">${e.number}</td>
					<td align="center">${e.name}</td>
					<td align="center">${e.idCard}</td>
					<td align="center">${e.sex}</td>
					<td align="center">${e.age}</td>
					<td align="center">${e.bir}</td>
					<td align="center">${e.education}</td>
					<td align="center">${e.nativePlace}</td>
					<td align="center">${e.department}</td>
					<td align="center">${e.post}</td>
					<td align="center">${e.grade}</td>
					<td align="center">${e.marriage}</td>
					<td align="center">${e.phone}</td>
					<td align="center">${e.addr}</td>
					<td align="center">${e.entryTime}</td>
					<td align="center"><input type="button" value="修改"
						onclick="change('${e.id}')"> <input type="button"
						value="删除" onclick="deleteOne('${e.id}')"></td>


				</tr>
			</c:forEach>
		</tbody>
	</table>

	<div id="foot" style="text-align: center;">
		<!-- 上一页 -->
		<c:if test="${employee.currentPage==1 }">
			<a href="javascript:void()">&laquo;</a>
		</c:if>
		<c:if test="${employee.currentPage!=1 }">
			<a
				href="${pageContext.request.contextPath}/mainBusiness?currentPage=${employee.currentPage-1}">&laquo;</a>
		</c:if>

		<c:forEach begin="1" end="${employee.totalPage}" var="page">
			
				${page}
			
		
		</c:forEach>

		<!-- 下一页 -->
		<c:if test="${employee.currentPage==employee.totalPage}">
			<a href="javascript:void()">&raquo;</a>
		</c:if>
		<c:if test="${employee.currentPage!=employee.totalPage }">
			<a
				href="${pageContext.request.contextPath}/mainBusiness?currentPage=${employee.currentPage+1}">&raquo;</a>
		</c:if><br />
		第${employee.currentPage}页
		总${employee.totalPage}页
	</div>



</body>
</html>