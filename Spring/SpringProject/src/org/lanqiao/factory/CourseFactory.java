package org.lanqiao.factory;

import org.lanqiao.newinstance.HtmlCourse;
import org.lanqiao.newinstance.ICourse;
import org.lanqiao.newinstance.JavaCourse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CourseFactory {
	//工厂模式，根据名字获取课程
	public static ICourse getCourse(String name)
	{
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		if(name.equals("java"))
		{
			return (ICourse)context.getBean("javaCourse");
		}
		else
		{
			return  (ICourse)context.getBean("htmlCourse");
		}
		
		
	}
}	
