package cn.Lionel.service.impl;

import cn.Lionel.dao.UserDao;
import cn.Lionel.dao.impl.UserDaoImpl;
import cn.Lionel.domain.User;
import cn.Lionel.exception.UserExistException;
import cn.Lionel.utils.ServiceUtils;

public class BusinessServiceImpl {

	private UserDao dao = new UserDaoImpl();
	
	public 	void register(User user) throws UserExistException
	{
		if(dao.find(user.getUsername())) 
		{
			throw new UserExistException(); //发现用户已足注册，则给web层抛一个编译时异常，提醒web层处理
			
		}
		else
		{

			user.setPassword(ServiceUtils.md5(user.getPassword()));
			
			dao.add(user);
			
		}
		
	}
	
	public User login(String username , String password)
	{
		String psw = ServiceUtils.md5(password);
		return dao.find(username, psw) ;
	}
}
