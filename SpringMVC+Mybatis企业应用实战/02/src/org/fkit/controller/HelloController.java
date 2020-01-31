package org.fkit.controller;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.stereotype.Controller;


@Controller
public class HelloController
{	
	private static final Log logger = LogFactory.getLog(HelloController.class);
	
	@RequestMapping("/hello")
	public ModelAndView hello()
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", "hello world");
		
		mv.setViewName("/WEB-INF/content/welcome.jsp");
		
		return mv;
	}
	
}





//public class HelloController implements Controller{
//
//	private static final Log logger = LogFactory.getLog(HelloController.class);
//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		// TODO Auto-generated method stub
//		
//		logger.info("HandleRequest被调用");
//		
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("message","HelloWorld!" );
//		
//		mv.setViewName("/WEB-INF/content/welcome.jsp");
//		return mv;
//	}
//	
//	
//}




