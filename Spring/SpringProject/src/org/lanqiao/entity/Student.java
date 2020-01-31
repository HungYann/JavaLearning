package org.lanqiao.entity;

import org.lanqiao.factory.CourseFactory;
import org.lanqiao.newinstance.HtmlCourse;
import org.lanqiao.newinstance.ICourse;
import org.lanqiao.newinstance.JavaCourse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Student {
	private int stuNo;
	private String stuName;
	private int stuAge;
	
	public int getStuNo() {
		return stuNo;
	}
	public void setStuNo(int stuNo) {
		this.stuNo = stuNo;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public int getStuAge() {
		return stuAge;
	}
	public void setStuAge(int stuAge) {
		this.stuAge = stuAge;
	}
	
	public String toStirng()
	{
		return this.stuNo+","+this.stuName+","+this.stuAge;
	}
	
	public void learnJava()
	{
		ICourse course = new JavaCourse();
		course.learn();
	}
	
	public void learnHtml()
	{
		ICourse course = new HtmlCourse();
		course.learn();
	}
	
	public void learn(String name)
	{
		//ICourse course = CourseFactory.getCourse(name);
		//course.learn();
		
		//直接拿
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ICourse course = (ICourse)context.getBean(name);
		
		course.learn();
		
		
	}
	
}
