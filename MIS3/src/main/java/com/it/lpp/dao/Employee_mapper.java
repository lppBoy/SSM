package com.it.lpp.dao;

import java.util.List;

import com.it.lpp.pojo.Employee;
import com.it.lpp.pojo.Administrators;

public interface Employee_mapper {
public List<Employee> selectAll();
public void deleteById(Integer id);
public Employee  selectById(Integer id);
public void updateById(Employee employee);
public void insert(Employee employee);
public List<Employee> queryByMost(Employee employee);
public Integer selectByNumber(String string);
}
