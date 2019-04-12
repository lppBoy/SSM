package com.it.lpp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.it.lpp.pojo.Administrators;
import com.it.lpp.service.EmployeeService;
import com.it.lpp.service.rootService;

@Controller
public class RootController {
	@Autowired
	private rootService rootservice;

	@RequestMapping("/insertRoot")
	public String insertRoot() {
		return "insertRoot";
	}

	@RequestMapping("/Secret11")
	public void Secret11(String secretkey, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		if (secretkey.equals("123")) {
			response.getWriter().write("[{\"num\":" + 1 + "}]");
		} else {
			response.getWriter().write("[{\"num\":" + 0 + "}]");
		}
	}

	@RequestMapping("/send")
	public void send(String mailbox, HttpServletRequest request, HttpServletResponse response) throws IOException {
		int code = (int) (Math.random() * 9000 + 1000);
		HttpSession session = request.getSession();
		session.setAttribute("code", code);
		String emailMsg = "您注册账号的验证码为：" + code + ",30分钟内有效！";
		try {
			utils.MailUtils.sendMail(mailbox, emailMsg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(" [{\"code\":" + code + "}]");
	}

	@RequestMapping("/login1")
	public void login1(String VerificationCode, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		int attribute = (int) request.getSession().getAttribute("code");
		String code = String.valueOf(attribute);
		PrintWriter writer = response.getWriter();
		if (code.equals(VerificationCode)) {
			writer.write(" [{\"code\":" + 1 + "}]");
		} else {
			writer.write(" [{\"code\":" + 0 + "}]");
		}
	}

	@RequestMapping("/loginMain")
	public String loginMain(String rootname, String password, String mailbox) throws IOException {
		try {
			password = new Md5Hash(password, "lpp", 3).toString();
			Administrators administrators = new Administrators();
			administrators.setRootname(rootname);
			administrators.setPassword(password);
			administrators.setMailbox(mailbox);
			rootservice.insertRoot(administrators);
			return "loginSucsess";
		} catch (Exception e) {
			return "error";
		}
	}

	@RequestMapping("/nameyanzheng")
	public void nameyanzheng(String rootname, HttpServletResponse response) throws IOException {
		Administrators administrators = new Administrators();
		administrators.setRootname(rootname);
		Administrators selectRoot = rootservice.selectRoot(administrators);
		if (null == selectRoot) {
			response.getWriter().write(" [{\"num\":" + 0 + "}]");
		} else {
			response.getWriter().write(" [{\"num\":" + 1 + "}]");
		}
	}

	@RequestMapping("/sendMsg")
	public void sendMsg(String rootname, HttpServletRequest request, HttpServletResponse response)
			throws IOException, AddressException, MessagingException {
		Administrators administrators = new Administrators();
		administrators.setRootname(rootname);
		Administrators selectRoot = rootservice.selectRoot(administrators);
		try {
			int code = (int) (Math.random() * 9000 + 1000);
			HttpSession session = request.getSession();
			session.setAttribute("code", code);
			String emailMsg = "验证码为：" + code + ",30分钟内有效！";
			utils.MailUtils.sendMail(selectRoot.getMailbox(), emailMsg);
			response.getWriter().write(" {\"num\":" + 1 + "}");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			response.getWriter().write(" {\"num\":" + 0 + "}");
		}
	}

	@RequestMapping("/inspectMsg")
	public void inspectMsg(String VerificationCode, HttpServletRequest request, HttpServletResponse response)
			throws IOException, AddressException, MessagingException {
		HttpSession session = request.getSession();
		String code = String.valueOf(session.getAttribute("code"));
		if (code.equals(VerificationCode)) {
			response.getWriter().write(" [{\"num\":" + 1 + "}]");
		} else {
			response.getWriter().write(" [{\"num\":" + 0 + "}]");
		}
	}

	@RequestMapping("/updateInfo")
	public String updateInfo(String rootname, String password, HttpServletResponse response)
			throws IOException, AddressException, MessagingException {
		String password2 = new Md5Hash(password, "lpp", 3).toString();
		Administrators administrators = new Administrators();
		administrators.setRootname(rootname);
		administrators.setPassword(password2);
		rootservice.updateRootPassword(administrators);
		return "loginSucsess";

	}

}
