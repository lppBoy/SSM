package com.it.lpp.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.lpp.dao.root_mapper;
import com.it.lpp.pojo.Administrators;
import com.it.lpp.pojo.Teacher;
@Service
public class rootServiceImpl implements rootService {
 @Autowired
	private root_mapper root;
	@Override
	public Administrators selectRoot(Administrators rootPojo) {
		// TODO Auto-generated method stub
		return root.selectRoot(rootPojo);
	}
	@Override
	public List<Teacher> selectTeacher() {
		// TODO Auto-generated method stub
		return root.selectTeacher();
	}
	@Override
	public List<Map> selectTeacher2() {
		// TODO Auto-generated method stub
		return root.selectTeacher2();
	}
	@Override
	public void insertRoot(Administrators administrators) {
		// TODO Auto-generated method stub
		root.insertRoot(administrators);
	}
	@Override
	public void updateRootPassword(Administrators administrators) {
		// TODO Auto-generated method stub
		root.updateRootPassword(administrators);
	}

}
