package com.springmvc.crud.handlers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.crud.dao.DepartmentDao;
import com.springmvc.crud.dao.EmployeeDao;
import com.springmvc.crud.entities.Employee;

@Controller
public class EmployeeHandler {

	@Autowired
	private EmployeeDao employeeDao;
	@Autowired
	private DepartmentDao departmentDao;
	
	@ModelAttribute
	public void getEmployee(@RequestParam(value="id", required=false) Integer id,
			Map<String, Object> map) {
		System.out.println("getEmployee");
		if(id != null){
			map.put("employee", employeeDao.get(id));
		}
		
	}
	
	/**
	 * 更新
	 * @param employee
	 * @return
	 */
	@RequestMapping(value="/emp", method=RequestMethod.PUT)
	public String update(Employee employee) {
		employeeDao.save(employee);
		return "redirect:/emps";
	}
	
	
	/**
	 * 修改页面
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/emp/{id}", method=RequestMethod.GET)
	public String input(@PathVariable("id") Integer id, Map<String, Object> map) {
		map.put("employee", employeeDao.get(id));
		map.put("departments", departmentDao.getDepartments());
		return "input";
	}
	

	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/emp/{id}", method=RequestMethod.DELETE)
	public String delete(@PathVariable("id") Integer id) {
		employeeDao.delete(id);
		return "redirect:/emps";
	}
	
	/**
	 * 添加操作
	 * @param employee
	 * @return
	 */
	@RequestMapping(value="/emp", method=RequestMethod.POST)
	public String save(Employee employee) {
		employeeDao.save(employee);
		return "redirect:/emps";
	}
	
	/**
	 * GET 听见新的employee，需要获取部门列表 显示目标页面（添加页面）
	 * @return
	 */
	@RequestMapping(value="/emp", method=RequestMethod.GET)
	public String input(Map<String, Object> map) {
		map.put("departments", departmentDao.getDepartments());
		//SpringMVC表单标签需要一个bean
		map.put("employee", new Employee());
		return "input";
	}
	
	
	
	@RequestMapping("/emps")
	public String list(Map<String, Object> map) {
		map.put("employees", employeeDao.getAll());
		return "list";
	}
	
}
