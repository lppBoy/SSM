package com.it.lpp.pojo;

import java.io.Serializable;

public class Administrators implements Serializable {

	private static final long serialVersionUID = 1L;
	private String rootname;
	private String password;
	private String mailbox;

	public String getRootname() {
		return rootname;
	}

	public void setRootname(String rootname) {
		this.rootname = rootname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMailbox() {
		return mailbox;
	}

	public void setMailbox(String mailbox) {
		this.mailbox = mailbox;
	}

	@Override
	public String toString() {
		return "Administrators [rootname=" + rootname + ", password=" + password + ", mailbox=" + mailbox + "]";
	}

}
