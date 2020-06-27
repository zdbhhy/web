package org.student.entity;

public class Assistants {
	String assname;
	 String username;
	 String password;
	 String sclass;
	public String getAssname() {
		return assname;
	}
	public void setAssname(String assname) {
		this.assname = assname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSclass() {
		return sclass;
	}
	@Override
	public String toString() {
		return "Assistants [assname=" + assname + ", username=" + username + ", password=" + password + ", sclass="
				+ sclass + "]";
	}
	public void setSclass(String sclass) {
		this.sclass = sclass;
	}

}
