package com.domain.dto;

public class Project {

	long projectId;
	long empId;
	
	String projectName;
	String empRole;
	//String exp;
	
	public Project() {}

	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getEmpRole() {
		return empRole;
	}

	public void setEmpRole(String empRole) {
		this.empRole = empRole;
	}

}