package org.lanqiao.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("SpringMVCHandler")
public class SpringMVCHandler {
	@RequestMapping(value="/welcome",method=RequestMethod.POST)//映射
	public String welcome()
	{	
		return "success";
	}
}
