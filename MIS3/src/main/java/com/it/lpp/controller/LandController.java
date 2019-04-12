package com.it.lpp.controller;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.it.lpp.pojo.Employee;
import com.it.lpp.pojo.Teacher;
import com.it.lpp.pojo.Administrators;
import com.it.lpp.service.EmployeeService;
import com.it.lpp.service.PageService;
import com.it.lpp.service.rootService;

import utils.PageBean;

@Controller
public class LandController {
	@Autowired
	private rootService rootservice;
	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/testMap")
	public String testMap() {
		List<Teacher> selectTeacher = rootservice.selectTeacher();
		for (Teacher teacher : selectTeacher) {
			System.out.println(teacher.toString());
		}
		return null;
	}

	@RequestMapping("/landController")
	public String landController(String rootname, String password, Model model, HttpServletRequest request) {
		UsernamePasswordToken token = new UsernamePasswordToken(rootname, password);
		try {
			Subject subject = SecurityUtils.getSubject();
			subject.login(token);
			// 这个用来存储上一次请求的路径（就是被拦截后跳转过来的情况）
			String requestUrl = "1";
			// 判断存储上一次请求路径的对象是否为空 为空表示不是被拦截
			if (WebUtils.getSavedRequest(request) != null) {
				// 获取上一次请求的路径
				requestUrl = WebUtils.getSavedRequest(request).getRequestUrl();
			}
			// 不是被拦截的情况 正常跳转指定页面
			if (requestUrl == "1") {
				return "forward:/mainBusiness";
			} else {
				// 是被拦截了，去掉请求路径中的项目名 重定向到上一次请求的路径
				String newRequestUrl = requestUrl.replace("/MIS3/", "");
				return "redirect:" + newRequestUrl;
			}
		} catch (UnknownAccountException e) {
			request.getSession().setAttribute("msg", "用户名或密码错误");
			return "redirect:/views/index.jsp";
		} catch (Exception e) {
			// 异常重新登陆
			// TODO: handle exception
			request.getSession().setAttribute("msg", "用户名或密码错误");
			return "redirect:/views/index.jsp";
		}
	}

	@RequiresPermissions("employee:list")
	@RequestMapping("/mainBusiness")
	public String business(HttpServletRequest request) {
		String attribute = null;
		attribute = (String) request.getAttribute("query");
		// 每页显示数据量
		int currentCount;
		List<Employee> employee = null;
		// 取得所需数据
		if ("yes".equals(attribute)) {
			employee = (List<Employee>) request.getAttribute("employee");
			if (request.getAttribute("flag").equals("no")) {
				currentCount = 10;
			} else {
				currentCount = employee.size();
			}
		} else {
			employee = employeeService.selectAll();
			currentCount = 10;
		}
		// 获取点击的页数
		String currentPageStr = null;
		currentPageStr = request.getParameter("currentPage");
		// 初始化当前为第一页
		if (currentPageStr == null) {
			currentPageStr = "1";
		}
		// 当前页
		int currentPage = Integer.parseInt(currentPageStr);
		// 初始化一个PageBean实例
		PageBean pageBean = null;
		try {
			pageBean = PageService.findPageBean(currentPage, currentCount, employee);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("employee", pageBean);
		Subject subject = SecurityUtils.getSubject();
		request.setAttribute("adm", subject.getPrincipal());
		return "business";

	}

	@RequestMapping("/logout")
	public String logout() {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "redirect:/views/index.jsp";
	}
}
