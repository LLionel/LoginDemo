package cn.Lionel.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.Lionel.domain.User;
import cn.Lionel.service.impl.BusinessServiceImpl;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		BusinessServiceImpl bsi = new BusinessServiceImpl();
		User user = bsi.login(username, password);
		if (user != null) {
			request.getSession().setAttribute("user", user);
			//登录成功后，让用户跳转到首页
			response.sendRedirect(request.getContextPath()+"/index.jsp");
			return ;
		}
		request.setAttribute("msg", "用户名或密码错误！");
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
