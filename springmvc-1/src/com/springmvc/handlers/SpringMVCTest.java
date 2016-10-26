package com.springmvc.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/springmvc")
public class SpringMVCTest {

	private static final String SUCCESS = "success";
	
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
	 * 1.method指定请求方法
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
