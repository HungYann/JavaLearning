package org.lanqiao.test;

import org.lanqiao.entity.AllCollectionType;
import org.lanqiao.entity.Course;
import org.lanqiao.entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	
	public static void learnCourse()
	{
		Student student = new Student();
		student.learnHtml();
		student.learnJava();
	}
	
	
	public static void learnCourseWithFactory()
	{
		Student student = new Student();
		student.learn("java");
	}
	
	public static void learnCourseWithIoc()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Student student = (Student)context.getBean("student");
		
		//Student student = new Student();
		student.learn("htmlCourse");
		
	}
	
	public static void testDT()
	{
			ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		 	Course course = (Course)context.getBean("course");
		 	course.showInfo();
	}
	
	public static void allCollectionType()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		AllCollectionType collectiontype = (AllCollectionType)context.getBean("collectionDemo");
		System.out.println(collectiontype);
	}
	
	public static void main(String[] args)
	{
		//1.先给springioc中放对象
		//2.拿
		
//		Student student = new Student();
//		student.setStuNo(1);
//		student.setStuName("zs");
//		student.setStuAge(23);
//		System.out.print(student);
		
		//spring
//		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//		Student student = (Student)context.getBean("student");
//		System.out.println(student.toStirng());
		
		
		//learnCourseWithIoc();
		
		
		//learnCourseWithFactory();
		//learnCourse();
		allCollectionType();
		//testDT();
	}
	
	
}
