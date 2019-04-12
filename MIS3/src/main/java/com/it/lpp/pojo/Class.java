package com.it.lpp.pojo;

import java.io.Serializable;

public class Class implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String  pId;
	private String  pName;
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}
	public String getPName() {
		return pName;
	}
	public void setPName(String pName) {
		pName = pName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Class [pId=" + pId + ", pName=" + pName + "]";
	}
	

}
