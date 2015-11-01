package cn.Lionel.formbean;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

public class RegisterForm {

	private String username ;
	private String password ;
	private String password2;
	private String email ;
	private String birthday;
	private String nickname;
	private Map<String , String> errors = new HashMap();
	
	public Map getErrors() {
		return errors;
	}
	public void setErrors(Map errors) {
		this.errors = errors;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password1) {
		this.password = password1;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	/*
	 * 用户名不能为空 长度为3-8位，为字母和数字
	 * 密码不能为空 长度为3-8位
	 * 确认密码不能为空，并且与密码相同。
	 * 电子邮箱不能为空，并且格式合法。
	 * 生日可以为空，不为空时一定要是日期
	 * 昵称不能为空，并且为汉字
	 * 
	 */
	public boolean validate()
	{
		boolean isOK = true ;
		
		//用户名不能为空 长度为3-8位，为字母和数字
		if(this.username == null || this.username.trim().equals(""))
		{
			isOK = false ;
			errors.put("username", "用户名不能为空");
			
		}
		else if(!this.username.matches("[A-Za-z0-9]{3,8}")) 
		{
			isOK = false ;
			errors.put("username", "用户名只能为数字和字母");
			
		}
		
		//密码不能为空 长度为3-8位
		if(this.password == null || this.password.trim().equals(""))
		{
			isOK = false ;
			errors.put("password1", "密码不能为空");
			
		}
		else if(!this.password.matches("[A-Za-z0-9]{3,8}")) 
		{
			isOK = false ;
			errors.put("password1", "密码只能为数字和字母");
			
		}
		//确认密码不能为空，并且与密码相同。
		if(this.password2 == null || this.password2.trim().equals(""))
		{
			isOK = false ;
			errors.put("password1", "确认密码不能为空");
			
		}
		else if(!this.password2.equals(password)) 
		{
			isOK = false ;
			errors.put("password2", "确认密码与密码不一致");
			
		}
		
		//电子邮箱不能为空，并且格式合法。
		if(this.email == null || this.email.trim().equals(""))
		{
			isOK = false ;
			errors.put("email", "邮箱不能为空");
			
		}
		else if(!this.email.matches("\\w+@\\w+\\.com"))
		{
			isOK = false ;
			errors.put("email", "邮箱不合法");
		}
		
		//生日可以为空，不为空时一定要是合法日期
		if(this.birthday != null && !this.birthday.trim().equals(""))
		{
			try {
				DateLocaleConverter dlc = new DateLocaleConverter();
				dlc.convert(this.birthday,"yyyy-MM-dd");
			} catch (Exception e) {
				isOK = false ;
				errors.put("birthday", "日期不合法");
			}
			
			
			
		}
		
		//昵称不能为空，并且为汉字
		if(this.nickname == null || this.nickname.trim().equals(""))
		{
			isOK = false ;
			errors.put("nickname", "昵称不能为空");
			
		}
		else if(!this.nickname.matches("[\u4E00-\u9FA5]+"))
		{
			isOK = false; 
			errors.put("nickname", "昵称只能为汉字");
		}
		
		
		return isOK ;
	}
	
}
