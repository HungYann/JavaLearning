package org.lanqiao.entity;

public class Course {
	private String courseName;
	private int courseHour;
	private Teacher teacher;//授课老师，依赖于teacher类
	
	
	public Course()
	{
		
	}
	
	public Course(String courseName, int courseHour, Teacher teacher) {
		super();
		this.courseName = courseName;
		this.courseHour = courseHour;
		this.teacher = teacher;
	}
	
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getCourseHour() {
		return courseHour;
	}
	public void setCourseHour(int courseHour) {
		this.courseHour = courseHour;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	public void showInfo()
	{
		System.out.println(this.courseName+","+this.courseHour+","+this.teacher.getName());
	}
	
	
}
