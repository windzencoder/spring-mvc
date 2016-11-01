package com.springmvc.handlers;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.entities.User;

@Controller
@RequestMapping("/springmvc")
@SessionAttributes(value={"user"}, types={String.class})
public class SpringMVCTest {

	private static final String SUCCESS = "success";
	
	@RequestMapping("/testView")
	public String testView(){
		System.out.println("testView");
		return "helloView";
	}
	
	
	@RequestMapping("/testViewAndViewResolver")
	public String testViewAndViewResolver() {
		System.out.println("testViewAndViewResolver");
		return SUCCESS;
	}
	
	
	
	@ModelAttribute
	public void getUser(@RequestParam(value="id", required=false) Integer id,
			Map<String, Object> map){
		System.out.println("@ModelAttribute");
		if (id != null) {
			
			//模拟从数据库中获取对象
			User user= new User(1, "tom", "123456", "123@123.com", 12);
			System.out.println("从数据库中获取一个对象：" + user);
			
			map.put("user", user);
		}
		
	}
	
	@RequestMapping("/testModelAttribute")
	public String testModelAttribute(@ModelAttribute("user") User user){
		System.out.println("修改：" + user);
		return SUCCESS;
	}
	
	/**
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("/testSessionAttributes")
	public String testSessionAttributes(Map<String, Object> map) {
//		User user = new User("wz", "hello");
//		map.put("user", user);
//		map.put("school", "wuhan");
		return SUCCESS;
		
	}
	
	
	/**
	 * 目标方法可以添加Map类型的参数，还可传入ModelMap或Model，通常传入Map类型
	 * @param map
	 * @return
	 */
	@RequestMapping("/testMap")
	public String testMap(Map<String, Object> map) {
		map.put("names", Arrays.asList("tom", "jerry", "mike"));
		return SUCCESS;
	}
	
	
	/**
	 * 目标方法的返回值可以是ModelAndView类型。
	 * 其中可以包含视图和视图模型信息
	 * @return
	 */
	@RequestMapping("/testModelAndView")
	public ModelAndView testModelAndView(){
		String viweName = SUCCESS;
		ModelAndView modelAndView = new ModelAndView(viweName);
		//添加模型数据到ModelAndView中
		modelAndView.addObject("time", new Date());
		return modelAndView;
	}
	
	
	@RequestMapping("/testRequestHeader")
	public String testRequestHeader(@RequestHeader(value="Accept-Language") String header){
		System.out.println("testRequestHeader, " + header);
		return SUCCESS;
	}
	
	
	@RequestMapping("/testRequestParam")
	public String testRequestParam(@RequestParam(value="username") String username,
			@RequestParam(value="age", required=false, defaultValue="0") int age){
		System.out.println("testRequestParam: username " + username);
		System.out.println("testRequestParam: age " + age);
		return SUCCESS;
	}
	
	
	
	@RequestMapping(value="/testRest/{id}", method=RequestMethod.PUT)
	@ResponseBody()
	public String testRestPut(@PathVariable("id") Integer id) {
		System.out.println("testRest PUT: " + id);
		return SUCCESS;
	}
	
	@RequestMapping(value="/testRest/{id}", method=RequestMethod.DELETE)
	@ResponseBody()
	public String testRestDelete(@PathVariable("id") Integer id) {
		System.out.println("testRest DELETE: " + id);
		return SUCCESS;
	}
	
	@RequestMapping(value="/testRest/{id}", method=RequestMethod.POST)
	public String testRest(@PathVariable("id") Integer id) {
		System.out.println("testRest POST: " + id);
		return SUCCESS;
	}
	
	
	@RequestMapping("/testPathVariable/{id}")
	public String testPathVariable(@PathVariable("id") Integer id) {
		System.out.println("testPathVariable " + id);
		return SUCCESS;
	}
	
	
	@RequestMapping(value="/testParamsAndHeaders", params={"username", "age!=10"}, headers={"Accept-Language=zh-CN,zh;q=0.8,en;q=0.6,zh-TW;q=0.4"})
	public String testParamsAndHeaders() {
		System.out.println("testParmasAndHeaders");
		return SUCCESS;
	}
	
	
	/*
	 * 1.method鎸囧畾璇锋眰鏂规硶
	 */
	@RequestMapping(value="/testMethod", method=RequestMethod.POST)
	public String testMethod() {
		System.out.println("testMethod");
		return SUCCESS;
	}
	
	
	@RequestMapping("/testRequestMapping")
	public String testRequestMapping() {
		System.out.println("testRequestMapping");
		return SUCCESS;
	}
	
}
