package cn.Lionel.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		
		if(session != null)
		{
			session.setMaxInactiveInterval(0);
		}
		
		//ע���ɹ�������ȫ����Ϣҳ�棬��ʾע���ɹ���Ϣ����������Ϣ��ʾҳ��3�����ת����ҳ
		request.setAttribute("msg", "ע���ɹ���<meta http-equiv= 'refresh' content = '3 ;url = "+request.getContextPath()+"/index.jsp'>");
		request.getRequestDispatcher("/message.jsp").forward(request, response);
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
