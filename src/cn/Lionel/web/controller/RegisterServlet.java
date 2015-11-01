package cn.Lionel.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.Lionel.domain.User;
import cn.Lionel.exception.UserExistException;
import cn.Lionel.formbean.RegisterForm;
import cn.Lionel.service.impl.BusinessServiceImpl;
import cn.Lionel.utils.WebUtils;

public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//1.���ύ�ı����ֶν��кϷ���У�飨�ѱ������ݷ�װ��formbean��;
		request.setCharacterEncoding("utf-8");
		RegisterForm form = WebUtils.request2Bean(request,RegisterForm.class);
		boolean b = form.validate();
		//2.�����֤ʧ�ܣ�����ת��ȥ������ʾ������Ϣ
		if(!b)
		{
			request.setAttribute("form", form) ;
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response) ;
			return ;
		}
		
		//3.��֤�ɹ�����FormBean�����ݿ�����User�
		
		User user = new User() ;
		WebUtils.copyBean(form, user) ;
		user.setId(WebUtils.gerneratID());
		
		BusinessServiceImpl bs = new BusinessServiceImpl();
		//4.ע���û�
		try {
			bs.register(user);
			request.setAttribute("msg", "��ϲ�㣬ע��ɹ���") ;
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return ;
		} catch (UserExistException e) {
			form.getErrors().put("username", "���û��Ѵ���");
			request.setAttribute("form",form);
//			request.setAttribute("msg", "���û��Ѵ���");
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
			return ;
//			throw new RuntimeException(e);
		}catch(Exception e)
		{
			//5�����Ϊ����ԭ��ע�᲻�ɹ�������ת��һ��ȫ�ֵĵĴ���ҳ��
			request.setAttribute("msg", "����������δ֪����");
			request.getRequestDispatcher("/message.jsp");
			
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
		
	}

}
