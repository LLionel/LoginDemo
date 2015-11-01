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
		
		//1.对提交的表单的字段进行合法的校验（把表单的数据封装到formbean）;
		request.setCharacterEncoding("utf-8");
		RegisterForm form = WebUtils.request2Bean(request,RegisterForm.class);
		boolean b = form.validate();
		//2.如果验证失败，就跳转回去，并显示错误信息
		if(!b)
		{
			request.setAttribute("form", form) ;
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response) ;
			return ;
		}
		
		//3.验证成功，把FormBean的数据拷贝到User里；
		
		User user = new User() ;
		WebUtils.copyBean(form, user) ;
		user.setId(WebUtils.gerneratID());
		
		BusinessServiceImpl bs = new BusinessServiceImpl();
		//4.注册用户
		try {
			bs.register(user);
			request.setAttribute("msg", "恭喜你，注册成功！") ;
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return ;
		} catch (UserExistException e) {
			form.getErrors().put("username", "该用户已存在");
			request.setAttribute("form",form);
//			request.setAttribute("msg", "该用户已存在");
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
			return ;
//			throw new RuntimeException(e);
		}catch(Exception e)
		{
			//5如果因为其他原因注册不成功吗，则跳转到一个全局的的错误页面
			request.setAttribute("msg", "服务器出现未知错误");
			request.getRequestDispatcher("/message.jsp");
			
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
		
	}

}
