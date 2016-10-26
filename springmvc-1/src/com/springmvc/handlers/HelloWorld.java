package com.springmvc.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorld {

	/**
	 * 1. 使用@RequestMapping来映射请求
	 * 2. 返回值会通过视图解析器解析为实际的物理视图。对于InternalResourceViewResolver
	 *  视图解析器，会做如下的解析: prefix+returnVal+suffix，得到实际的物理视图，然后做转发
	 *  
	 *  /WEB-INF/views/success.jsp
	 * @return
	 */
	@RequestMapping("/helloworld")
	public String hello() {
		System.out.println("hello world");
		return "success";
	}
	
}
