package com.it.lpp.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.it.lpp.service.EmployeeService;

@Controller
public class DeleteController {
	@Autowired
	private EmployeeService employeeService;
	@RequiresPermissions("employee:*")
	@RequestMapping("/deleteOne")
	public String deleteOne(int code) {
		employeeService.deleteById(code);
		return "forward:/mainBusiness";
	}
}
