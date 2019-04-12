package com.it.lpp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.it.lpp.pojo.Employee;
import com.it.lpp.service.EmployeeService;

@Controller
public class QueryController {
	@Autowired
	private EmployeeService employeeService;

	@RequiresPermissions("employee:list")
	@RequestMapping("/query")
	public String query(String number, String name, String idCard, int sex, HttpServletRequest request) {
		Employee employee = new Employee();
		if (number != "") {
			employee.setNumber(number);
		} else
			employee.setNumber(null);
		if (name != "") {
			employee.setName(name);
		} else {
			employee.setName(null);
		}
		if (idCard != "") {
			employee.setIdCard(idCard);
		} else {
			employee.setIdCard(null);
		}
		if (sex == 1) {
			employee.setSex("男");

		} else if (sex == 2) {
			employee.setSex("女");
		} else {
			employee.setSex(null);
		}
		if (number == "" && name == "" && idCard == "" && sex == 0) {
			request.setAttribute("flag", "no");
		} else {
			request.setAttribute("flag", "yes");
		}
		List<Employee> queryByMost = employeeService.queryByMost(employee);
		request.setAttribute("employee", queryByMost);
		request.setAttribute("query", "yes");
		return "forward:/mainBusiness";
	}
}
