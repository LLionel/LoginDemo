package cn.Lionel.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;


public class WebUtils {

	public static <T> T request2Bean(HttpServletRequest request , Class<T> beanClass)
	{
		
		try {
			T bean = beanClass.newInstance();
			Enumeration e = request.getParameterNames();
			
			while(e.hasMoreElements())
			{
				String name = (String)e.nextElement();
				String value = request.getParameter(name);
				BeanUtils.setProperty(bean, name, value);
			}
			return bean ;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}
	public static void copyBean(Object src , Object dest)
	{
		
		//由于不能转换复杂类型，需要注册，把字符串转成日期
		ConvertUtils.register(new Converter() {
			
			@Override
			public Object convert(Class type, Object value) {
				if(value == null)
				{
					return null;
				}
				String str = (String) value ;
				if(str.trim().equals(""))
				{
					return null ;
				}
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				
				try {
					return sdf.parse(str);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					throw new RuntimeException(e);
				}
			}
		}, Date.class);
		
		try {
			BeanUtils.copyProperties(dest, src);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public static String gerneratID()
	{
		//通过网卡号产生唯一的随机数
		return UUID.randomUUID().toString();
	}
}
