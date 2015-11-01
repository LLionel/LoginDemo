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
			//��¼�ɹ������û���ת����ҳ
			response.sendRedirect(request.getContextPath()+"/index.jsp");
			return ;
		}
		request.setAttribute("msg", "�û������������");
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
