package com.it.lpp.service;

import java.util.List;
import java.util.Map;

import com.it.lpp.pojo.Administrators;
import com.it.lpp.pojo.Teacher;

public interface rootService {
	public Administrators selectRoot(Administrators rootPojo);
	public List<Teacher>    selectTeacher();
	public List<Map> selectTeacher2();
	public void insertRoot(Administrators administrators);
	public void updateRootPassword(Administrators administrators);
}
