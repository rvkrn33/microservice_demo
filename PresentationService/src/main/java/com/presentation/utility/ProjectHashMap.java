package com.presentation.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.presentation.dto.Employee;
import com.presentation.dto.Project;

public class ProjectHashMap {
	
	static List<Project> prjList=new ArrayList();

	static String[] projName= {"CITI","SBI","ICICI","BOI"};
	static String[] tectStack= {"UI","Service","DB","Testing","Reviwer"};
	
	public static Project assignProject(Employee emp) {
		Project prj=new Project();
		prj.setEmpId(emp.getEmpId());
		if(emp.getTechStack().equals("UI")) {
			prj.setProjName(projName[1]);
		}
		
		if(emp.getExp()>12)
			prj.setEmpRole("Manager");
		else if(emp.getExp() > 8 && emp.getExp() < 12)
			prj.setEmpRole("AST");
		else if(emp.getExp() > 4 && emp.getExp() < 8)
			prj.setEmpRole("IT Analyst");
		else
			prj.setEmpRole("Associate");
		
		prj.setDoj("12-10-2019");
		
		prjList.add(prj);
		
		return prj;
	}

	public static Project getProject(long empId) {
		return prjList.stream().filter(prj->prj.getEmpId()==empId).collect(Collectors.toList()).get(0);
	}
}

