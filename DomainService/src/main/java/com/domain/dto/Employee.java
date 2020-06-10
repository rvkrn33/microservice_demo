package com.domain.dto;

public class Employee {

	private long empId;
	
	private String empName;
	private String address;
	private long phno;
	private String email;
	private long exp;
	private String techStack;
	
	private String role;
	private String prjName;
	
	public long getEmpId() {
		return empId;
	}
	public void setEmpId(long empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPhno() {
		return phno;
	}
	public void setPhno(long phno) {
		this.phno = phno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTechStack() {
		return techStack;
	}
	public void setTechStack(String techStack) {
		this.techStack = techStack;
	}
	public long getExp() {
		return exp;
	}
	public void setExp(long exp) {
		this.exp = exp;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPrjName() {
		return prjName;
	}
	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}
	
	
}
