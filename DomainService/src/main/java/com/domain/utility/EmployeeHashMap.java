package com.domain.utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import com.domain.dto.Employee;

public class EmployeeHashMap {

	static ConcurrentHashMap<Long,Employee> empHashMap=new ConcurrentHashMap<Long,Employee>();;
	static String[] empName= {"Sumit","Amit","Rajesh","Suresh","Ganesh","Ravi","Sandesh","Raj"};
	static String[] empAddress= {"Pune","Mumbai","Panji","Delhi","Amritsar","Indore","Nagpur","Kolkata"};
	static HashMap<Integer,String> techStach= new HashMap<Integer, String>();
	  
	static {
		System.out.println("Static block executing..........");
		techStach.put(1,"UI");
		techStach.put(2,"Service");
		techStach.put(3,"DB");
		techStach.put(4,"Testing");
		techStach.put(5,"Reviewer");

		Employee emp=null;
		for(int i=1; i<8; i++) {
			emp=new Employee();
			emp.setEmpId(i);
			emp.setEmpName(empName[i]);
			emp.setAddress(empAddress[i]);
			emp.setPhno(875312325+(i));
			emp.setEmail(empName[i]+i+"@gmail.com");
			
			if(techStach.containsKey(i)) {
				emp.setTechStack(techStach.get(i));
			}else {
				emp.setTechStack(techStach.get(3));
			}
			long a=i+1;
			empHashMap.put(a,emp);
		}	
	}
   	
	public static long addAndUpdateEmployee(Employee emp) {
		long empId=0;
		if(emp.getEmpId()==0) {
			
			//added new employee
			empId=empHashMap.size()+1;
			empHashMap.put(empId, emp);
			
			System.out.println("New Object >>>>> "+empHashMap.get(empId).toString());
			//Check email Id alredy exist or not
			
		}else {
			//update
		}
		
		empHashMap.put(empId, emp);
		
		return empId;
	}
	
	public static List<Employee> getAllEmployees() {
		return empHashMap.values().stream().collect(Collectors.toList());

	}

	public static Employee getEmployee(String findByIdAndName) {
		
		List<Employee> list=empHashMap.values().stream().collect(Collectors.toList());
		
		for(Employee emp:list) {
			if(String.valueOf(emp.getEmpId()).equals(findByIdAndName)) {
				return emp;
			}
			if(emp.getEmpName().equals(findByIdAndName)) {
				return emp;
			}
		}
		
		return null;
	}
	
}
