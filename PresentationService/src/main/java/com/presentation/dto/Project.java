package com.presentation.dto;

public class Project {

    private long empId;
    private String projName;
    private String empRole;
    private String doj;
    private String exp;
    
	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getProjName() {
		return projName;
	}

	public void setProjName(String projName) {
		this.projName = projName;
	}

	public String getEmpRole() {
		return empRole;
	}

	public void setEmpRole(String empRole) {
		this.empRole = empRole;
	}

	public String getDoj() {
		return doj;
	}

	public void setDoj(String doj) {
		this.doj = doj;
	}

	public String getExp() {
		return exp;
	}

	public void setExp(String exp) {
		this.exp = exp;
	}

	@Override
	public String toString() {
		return "Project [empId=" + empId + ", projName=" + projName + ", empRole=" + empRole
				+ ", doj=" + doj + ", exp=" + exp + "]";
	}
    
}
