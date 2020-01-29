package org.lanqiao.converter;

import org.lanqiao.entity.Student;
import org.springframework.core.convert.converter.Converter;

public class MyConverter implements Converter<String,Student> {

	@Override
	public Student convert(String source) {
		// TODO Auto-generated method stub
		String[] stringStr =  source.split("-");
		
		Student student = new Student();
		student.setId(Integer.parseInt(stringStr[0]));
		student.setName(stringStr[1]);
		student.setAge(Integer.parseInt(stringStr[1]));
		
		return student;
	}

	
	
}
