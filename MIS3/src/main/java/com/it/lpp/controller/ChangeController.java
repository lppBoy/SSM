package com.it.lpp.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.it.lpp.pojo.Employee;
import com.it.lpp.service.EmployeeService;

@Controller
public class ChangeController {
	@Autowired
	private EmployeeService employeeService;
	@RequiresPermissions("employee:*")
	@RequestMapping("/changeOrInsert")
	public String ChangeOrInsert(int code, HttpServletRequest request) {
		if (code == 0) {
			return "insert";
		} else {
			Employee employee = employeeService.selectById(code);
			request.setAttribute("employee", employee);
			return "change";
		}
	}
	@RequiresPermissions("employee:*")
	@RequestMapping("/change")
	public String change(HttpServletRequest request) throws ParseException {
		Employee employee = new Employee();

		employee.setId(Integer.parseInt(request.getParameter("id")));
		employee.setNumber(request.getParameter("number"));
		employee.setName(request.getParameter("name"));
		employee.setIdCard(request.getParameter("idCard"));
		employee.setSex(request.getParameter("sex"));
		employee.setAge(Integer.parseInt(request.getParameter("age")));
		String time = request.getParameter("bir");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// yyyy-mm-dd,
																	// 会出现时间不对,
																	// 因为小写的mm是代表:
																	// 秒
		Date date = sdf.parse(time);
		employee.setBir(date);
		employee.setEducation(request.getParameter("education"));
		employee.setNativePlace(request.getParameter("nativePlace"));
		employee.setDepartment(request.getParameter("department"));
		employee.setPost(request.getParameter("post"));
		employee.setGrade(request.getParameter("grade"));
		employee.setMarriage(request.getParameter("marriage"));
		employee.setPhone(request.getParameter("phone"));
		employee.setAddr(request.getParameter("addr"));
		String entryTime = request.getParameter("entryTime");
		Date date2 = sdf.parse(entryTime);
		employee.setEntryTime(date2);
		employeeService.updateById(employee);
		return "forward:/mainBusiness";
	}
	
	@RequiresPermissions("employee:*")
	@RequestMapping("/insertOne")
	public String insert(HttpServletRequest request) throws ParseException {
		Employee employee = new Employee();
		employee.setNumber(request.getParameter("number"));
		employee.setName(request.getParameter("name"));
		employee.setIdCard(request.getParameter("idCard"));
		employee.setSex(request.getParameter("sex"));
		employee.setAge(Integer.parseInt(request.getParameter("age")));
		String time = request.getParameter("bir");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// yyyy-mm-dd,
																	// 会出现时间不对,
																	// 因为小写的mm是代表:
																	// 秒
		Date date = sdf.parse(time);
		employee.setBir(date);
		employee.setEducation(request.getParameter("education"));
		employee.setNativePlace(request.getParameter("nativePlace"));
		employee.setDepartment(request.getParameter("department"));
		employee.setPost(request.getParameter("post"));
		employee.setGrade(request.getParameter("grade"));
		employee.setMarriage(request.getParameter("marriage"));
		employee.setPhone(request.getParameter("phone"));
		employee.setAddr(request.getParameter("addr"));
		String entryTime = request.getParameter("entryTime");
		Date date2 = sdf.parse(entryTime);
		employee.setEntryTime(date2);
		employeeService.insert(employee);
		return "redirect:/mainBusiness";
	}

	@RequestMapping("/QueryNumber")
	public void QueryNumber(HttpServletRequest request, HttpServletResponse response)
			throws ParseException, IOException {
		String number = request.getParameter("number");
		Integer selectByNumber = 0;
		selectByNumber = employeeService.selectByNumber(number);
		// response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write("[{\"num\":" + selectByNumber + "}]");

	}
}
