package junit.test;

import java.util.Date;

import org.junit.Test;

import cn.Lionel.domain.User;
import cn.Lionel.exception.UserExistException;
import cn.Lionel.service.impl.BusinessServiceImpl;

public class ServiceTest {

	@Test
	public void testRegister()
	{
		User user = new User() ;
		user.setBirthday(new Date());
		user.setEmail("cc@sina.com");
		user.setId("3333");
		user.setNickname("Tonny");
		user.setPassword("5678");
		user.setUsername("Tony");
		BusinessServiceImpl bs = new BusinessServiceImpl()	;
		try {
			bs.register(user);
			System.out.println("注册成功");
		} catch (UserExistException e) {
			// TODO Auto-generated catch block
			System.out.println("用户已存在");
		}
	}
	
	@Test
	public void testLogin()
	{
		BusinessServiceImpl bs = new BusinessServiceImpl()	;
		User user = bs.login("aaa", "123");
		System.out.println(user);
	}
}
