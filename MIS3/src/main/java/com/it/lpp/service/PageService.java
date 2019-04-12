package com.it.lpp.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.it.lpp.pojo.Employee;

import utils.PageBean;



public class PageService {


	public static PageBean<Employee> findPageBean(int currentPage, int currentCount,List<Employee> employee) throws SQLException {
		// TODO Auto-generated method stub
        PageBean pageBean = new PageBean();
		// 当前页
		pageBean.setCurrentPage(currentPage);
		// 当前页显示的条数
		pageBean.setCurrentCount(currentCount);
		// 数据总数
		pageBean.setTatalCount(employee.size());
		// 总 页数
		int totalPage = (int) Math.ceil(1.0 * employee.size() / currentCount);
		pageBean.setTotalPage(totalPage);
		
		// 每页显示的数据
        int index = (currentPage-1)*currentCount; 
        //初始化一个List
        List<Employee> employee1 = new ArrayList<Employee>();
        
        if(((currentPage-1)*currentCount+currentCount)>employee.size() ){
        	  for(int i = (currentPage-1)*currentCount;i<employee.size();i++){
              	employee1.add(employee.get(i));
              }
        }else{
        	 for(int i = (currentPage-1)*currentCount;i<(currentPage-1)*currentCount+currentCount;i++){
             	employee1.add(employee.get(i));
             }
        }
        
        
       
		
		

		pageBean.setProductList(employee1);
		
		return pageBean;
	}
	
}
