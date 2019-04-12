package com.it.lpp.pojo;

import java.io.Serializable;
import java.util.List;

public class Teacher implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String tName;
private String tClassId;
private List<Class> classes;
public String gettName() {
	return tName;
}
public void settName(String tName) {
	this.tName = tName;
}
public String gettClassId() {
	return tClassId;
}
public void settClassId(String tClassId) {
	this.tClassId = tClassId;
}
public List<Class> getClasses() {
	return classes;
}
public void setClasses(List<Class> classes) {
	this.classes = classes;
}
@Override
public String toString() {
	return "Teacher [tName=" + tName + ", tClassId=" + tClassId + ", classes=" + classes + "]";
}






}
