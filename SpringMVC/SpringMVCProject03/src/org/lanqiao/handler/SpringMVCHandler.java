package org.lanqiao.handler;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;


//@SessionAttributes(types={Student.class,Address.class}) //如果要在request中存放student4 对象，同时也在session中存放
@Controller
@RequestMapping("SpringMVCHandler")
public class SpringMVCHandler {
	//springmvc映射
	@RequestMapping(value="/welcome1")//映射
	public String welcome()
	{	
		return "success";
	}
	
	//springmvc name,age
	@RequestMapping(value="/welcome2",method=RequestMethod.POST,params={"name=zs","age=23","!height"})
	public String welcome2()
	{
		return "success";
	}
	
	//*  任意目录
	//** 任意路径
	//?  单字符
	
	
	//通过PathVariable获得动态参数
	
	@RequestMapping(value="/welcome3/{name}")
	public String welcome3(@PathVariable("name") String name) 
	{
		System.out.println(name);
		return "success";
	}
	
	//rest的增删改查
	@RequestMapping(value="/welcome4/{id}")
	public String welcome4(@PathVariable("id") Integer id)
	{
		System.out.println("查"+id);
		return "success";
	}
	
	@RequestMapping(value="/welcome5/{id}")
	public String welcome5(@PathVariable("id") Integer id)
	{
		System.out.println("增"+id);
		return "success";
	}
	
	@RequestMapping(value="/welcome6/{id}",method=RequestMethod.DELETE)
	public String welcome6(@PathVariable("id") Integer id)
	{
		System.out.println("删"+id);
		return "success";
	}
	
	@RequestMapping(value="/welcome7/{id}", method=RequestMethod.PUT)
	public String welcome7(@PathVariable("id") Integer id)
	{
		System.out.println("改"+id);
		return "success";
	}
	
	//或者表中value字段
	@RequestMapping(value="/welcome8")
	public String welcome8(@RequestParam("uname") String string, @RequestParam(value="uage",required=false,defaultValue="23") Integer  age)
	{
		System.out.println(string);
		
		return "success";
	}
	
	//获取请求头信息
	
	@RequestMapping(value="/testRequestHeader")
	public String testRequestHeader(@RequestHeader("Accept-language") String requestheader)
	{
		System.out.print(requestheader);
		return "success";
	}
	
	//测试CookieValue值
	
	@RequestMapping(value="/testcookievalue")
	public String testCookieValue(@CookieValue("JSESSIONID") String sessionid)
	{
		System.out.print(sessionid);
		return "success";
	}
	
	//测试对象属性
	
	@RequestMapping(value="testObjectProperties")
	public String testObjectProperties(Student student)
	{
		System.out.print(student.getId()+","+student.getName()+","+student.getAddress().getHomeAddress()+","+student.getAddress().getSchoolAddress());
		return "success";
	}
	
	//MVC里使用原生态API
	@RequestMapping(value="testServletAPI")
	public String testServletAPI(HttpServletRequest request, HttpServletResponse response)
	{
		String str = (String)request.getParameter("uname");
		System.out.print(str);
		return "success";
				
	}	
	
	//Model and View
	@RequestMapping(value="testModelAndView")
	public ModelAndView testModelAndView()
	{
		ModelAndView mv = new ModelAndView("success");
		Student student = new Student();
		student.setId(2);
		student.setName("zs");
		
		mv.addObject("student1",student);
		return mv;
	}
	//Model
	@RequestMapping(value="testModel")
	public String testModel(Model model)
	{
		Student student = new Student();
		student.setId(2);
		student.setName("zs");
		model.addAttribute("student2", student);
		
		return "success";
	}
	
	//ModelMap
	@RequestMapping(value="testModelMap")
	public String testModelMap(ModelMap modelmap)
	{
		Student student = new Student();
		student.setId(3);
		student.setName("zs");
		
		modelmap.put("student3", student);
		return "redirect:/views/success.jsp";
	}
	
	//Map
	@RequestMapping(value="testMap")
	public String testMap(Map<String, Object> map)
	{
		Student student = new Student();
		student.setId(3);
		student.setName("zs");
		
		map.put("student4", student);
		
		return "success";
	}
	
	
	//修改：使用Model and view
	
	@ModelAttribute
	public void queryStudentById(ModelMap modelmap)
	{
		Student student = new Student();
		student.setId(31);
		student.setName("zs");
		student.setAge(23); 
		modelmap.addAttribute("student",student); //约定map的key 是方法参数类型的首字母
		
	}
	
	//在请求该类的各个方法前均被执行的设计思想：一个控制器只做一个功能
	@RequestMapping("testModelAttribute")
	public String testModelAttribute(@ModelAttribute("student") Student student)
	{
		student.setName("ls");
		System.out.print(student.getId()+","+student.getAge()+","+student.getName());
		return "success";
	}
	
	//国际化
	
	@RequestMapping("testI18N")
	public String testI18N()
	{
	
		return "success";
	}
	
	/*
	mvc直接从VIEW跳转到success.jsp页面
	<mvc:view-controller path="SpringMVCHandler/testMVCViewController view-name="success">
	<mvc:annotation-driven></mvc:annotation-driven>
	*/

	//指定跳转方式forward、redirect
	//forward请求转发   /views/success.jsp
	//redirect重定向需要/views/success.jsp
	
	//类型转换，将string->对象类型
	//
	@RequestMapping("testTypeConverter")
	public String testTypeConverter(@RequestParam("studentInfo") Student student)
	{
		System.out.print(student.getId());
		return "success";
	}
	
}

