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
	 * �û�������Ϊ�� ����Ϊ3-8λ��Ϊ��ĸ������
	 * ���벻��Ϊ�� ����Ϊ3-8λ
	 * ȷ�����벻��Ϊ�գ�������������ͬ��
	 * �������䲻��Ϊ�գ����Ҹ�ʽ�Ϸ���
	 * ���տ���Ϊ�գ���Ϊ��ʱһ��Ҫ������
	 * �ǳƲ���Ϊ�գ�����Ϊ����
	 * 
	 */
	public boolean validate()
	{
		boolean isOK = true ;
		
		//�û�������Ϊ�� ����Ϊ3-8λ��Ϊ��ĸ������
		if(this.username == null || this.username.trim().equals(""))
		{
			isOK = false ;
			errors.put("username", "�û�������Ϊ��");
			
		}
		else if(!this.username.matches("[A-Za-z0-9]{3,8}")) 
		{
			isOK = false ;
			errors.put("username", "�û���ֻ��Ϊ���ֺ���ĸ");
			
		}
		
		//���벻��Ϊ�� ����Ϊ3-8λ
		if(this.password == null || this.password.trim().equals(""))
		{
			isOK = false ;
			errors.put("password1", "���벻��Ϊ��");
			
		}
		else if(!this.password.matches("[A-Za-z0-9]{3,8}")) 
		{
			isOK = false ;
			errors.put("password1", "����ֻ��Ϊ���ֺ���ĸ");
			
		}
		//ȷ�����벻��Ϊ�գ�������������ͬ��
		if(this.password2 == null || this.password2.trim().equals(""))
		{
			isOK = false ;
			errors.put("password1", "ȷ�����벻��Ϊ��");
			
		}
		else if(!this.password2.equals(password)) 
		{
			isOK = false ;
			errors.put("password2", "ȷ�����������벻һ��");
			
		}
		
		//�������䲻��Ϊ�գ����Ҹ�ʽ�Ϸ���
		if(this.email == null || this.email.trim().equals(""))
		{
			isOK = false ;
			errors.put("email", "���䲻��Ϊ��");
			
		}
		else if(!this.email.matches("\\w+@\\w+\\.com"))
		{
			isOK = false ;
			errors.put("email", "���䲻�Ϸ�");
		}
		
		//���տ���Ϊ�գ���Ϊ��ʱһ��Ҫ�ǺϷ�����
		if(this.birthday != null && !this.birthday.trim().equals(""))
		{
			try {
				DateLocaleConverter dlc = new DateLocaleConverter();
				dlc.convert(this.birthday,"yyyy-MM-dd");
			} catch (Exception e) {
				isOK = false ;
				errors.put("birthday", "���ڲ��Ϸ�");
			}
			
			
			
		}
		
		//�ǳƲ���Ϊ�գ�����Ϊ����
		if(this.nickname == null || this.nickname.trim().equals(""))
		{
			isOK = false ;
			errors.put("nickname", "�ǳƲ���Ϊ��");
			
		}
		else if(!this.nickname.matches("[\u4E00-\u9FA5]+"))
		{
			isOK = false; 
			errors.put("nickname", "�ǳ�ֻ��Ϊ����");
		}
		
		
		return isOK ;
	}
	
}
