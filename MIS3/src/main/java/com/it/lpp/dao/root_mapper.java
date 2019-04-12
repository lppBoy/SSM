package com.it.lpp.dao;

import java.util.List;
import java.util.Map;

import com.it.lpp.pojo.Employee;
import com.it.lpp.pojo.Teacher;
import com.it.lpp.pojo.Administrators;

public interface root_mapper {
public Administrators selectRoot(Administrators rootPojo);
public List<Teacher>    selectTeacher();
public List<Map> selectTeacher2();
public void insertRoot(Administrators administrators);
public void updateRootPassword(Administrators administrators);
}
