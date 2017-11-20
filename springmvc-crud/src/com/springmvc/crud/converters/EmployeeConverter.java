package com.springmvc.crud.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.springmvc.crud.entities.Department;
import com.springmvc.crud.entities.Employee;

@Component
public class EmployeeConverter implements Converter<String, Employee> {

	@Override
	public Employee convert(String source) {
		System.out.println("EmployeeConverter");
		if (source != null) {
			String[] vals = source.split("-");
			if (vals != null && vals.length == 4) {
				String lastName = vals[0];
				String email = vals[1];
				String gender = vals[2];
				Department department = new Department();
				department.setId(Integer.parseInt(vals[3]));
				
				Employee employee = new Employee(null, lastName, email, gender, department);
				System.out.println(source+"--convert--:"+employee);
				return employee;
		
			}
		}
		return null;
	}

}
