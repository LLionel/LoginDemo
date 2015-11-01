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
			throw new UserExistException(); //�����û�����ע�ᣬ���web����һ������ʱ�쳣������web�㴦��
			
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
