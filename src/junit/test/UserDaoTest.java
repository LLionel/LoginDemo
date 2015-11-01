package junit.test;

import java.util.Date;

import org.junit.Test;

import cn.Lionel.dao.UserDao;
import cn.Lionel.dao.impl.UserDaoImpl;
import cn.Lionel.domain.User;

public class UserDaoTest {
	
	@Test
	public void testAdd()
	{
		User user = new User() ;
		user.setBirthday(new Date());
		user.setEmail("bb@sina.com");
		user.setId("2222");
		user.setNickname("Tommy");
		user.setPassword("1234");
		user.setUsername("Tom");
		UserDao dao = new UserDaoImpl();
		dao.add(user);
		
	}
	
	@Test
	public void testFind()
	{
		UserDao dao = new UserDaoImpl();
		User user = dao.find("aaaa", "dLhzN0VCANTTP4DEZj3F5Q==");
		if(dao.find("aaa"))
		{
			System.out.println("aaaa");
		}
		
	}
	@Test
	public void testFindByName()
	{
		UserDao dao = new UserDaoImpl();
		Boolean b = dao.find("Tony");
		return ;
	}
}
