package cn.Lionel.dao.impl;

import java.text.SimpleDateFormat;

import org.dom4j.Document;
import org.dom4j.Element;

import cn.Lionel.dao.UserDao;
import cn.Lionel.domain.User;
import cn.Lionel.utils.XmlUtils;

public class UserDaoImpl implements UserDao {

	public void add(User user)
	{
		try {
			Document document = XmlUtils.getDocument();
			Element root = document.getRootElement();
			root.addElement("user")
			.addAttribute("id", user.getId())
			.addAttribute("username", user.getUsername())
			.addAttribute("password", user.getPassword())
			.addAttribute("email", user.getEmail())
			.addAttribute("Date", user.getBirthday()==null?"":user.getBirthday().toLocaleString())
			.addAttribute("nickname", user.getNickname());
			
			XmlUtils.write2Xml(document);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	public User find(String username,String password)
	{
		try {
			Document document = XmlUtils.getDocument();
			Element e =(Element) document.selectSingleNode("//user[@username='"+username+"' and @password='"+password+"']");// (Element) document.selectSingleNode("//user[@username='aaa']") ;
			if(e == null)
			{
				return null;
			}
			User user = new User() ;
			String date = e.attributeValue("birthday") ;
			if(date == null || date.equals(""))
			{
				user.setBirthday(null);
			}
			else
			{
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				
				user.setBirthday(df.parse(date));
			}
			
			user.setEmail(e.attributeValue("email")) ;
			user.setId(e.attributeValue("id")) ;
			user.setNickname(e.attributeValue("nickname"));
			user.setPassword(e.attributeValue("password"));
			user.setUsername(e.attributeValue("username")) ;
			return user;
		} catch (Exception e) {
			throw new RuntimeException();
		}
		
		
	}
	
	public boolean find(String username)
	{
		try {
			Document document = XmlUtils.getDocument();
			Element e = (Element) document.selectSingleNode("//user[@username='"+username+"']");
			if(e == null)
			{
				return false;
			}
			
			return true;
		} catch (Exception e) {
			throw new RuntimeException();
		}
		
	}
	
}
