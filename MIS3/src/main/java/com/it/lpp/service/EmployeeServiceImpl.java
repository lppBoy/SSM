package com.it.lpp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.lpp.dao.Employee_mapper;
import com.it.lpp.pojo.Employee;
import com.it.lpp.pojo.Administrators;
@Service
public class EmployeeServiceImpl implements EmployeeService{
     @Autowired
	private Employee_mapper employee_mapper;
	@Override
	public List<Employee> selectAll() {
		// TODO Auto-generated method stub
		
		return employee_mapper.selectAll();
	}
	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		employee_mapper.deleteById(id);
	}
	@Override
	public Employee selectById(Integer id) {
		// TODO Auto-generated method stub
		return employee_mapper.selectById(id);
	}
	@Override
	public void updateById(Employee employee) {
		// TODO Auto-generated method stub
		employee_mapper.updateById(employee);
	}
	@Override
	public void insert(Employee employee) {
		// TODO Auto-generated method stub
		employee_mapper.insert(employee);
	}
	@Override
	public  List<Employee>  queryByMost(Employee employee) {
		// TODO Auto-generated method stub
		return employee_mapper.queryByMost(employee);
	}
	@Override
	public Integer selectByNumber(String string) {
		// TODO Auto-generated method stub
		return employee_mapper.selectByNumber(string);
	}

	



}
