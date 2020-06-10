package com.domain.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.domain.dto.Employee;
import com.domain.dto.Project;
import com.domain.utility.EmployeeHashMap;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;


@RefreshScope
@RestController
public class EmployeeController {
	
	 @Autowired
	 private AppProperties app;
	 
	 @Autowired
	    private RestTemplate restTemplate;
	    @Autowired
	    private EurekaClient eurekaClient;
	
	@PostMapping("/addEmp")
	public Employee saveEmployee(@RequestBody Employee emp) {
		
		long id=EmployeeHashMap.addAndUpdateEmployee(emp);
		emp.setEmpId(id);
		System.out.println("Save data "+" id is "+id+" ... "+emp.toString());
		return emp;
	}
	
	@GetMapping("/employees")
	public List<Employee> getAllemployees() {
		return EmployeeHashMap.getAllEmployees();
	}
	
	@GetMapping("/viewEmp/{findByIdAndName}")
	public Employee viewEmployee(@PathVariable String findByIdAndName) {
		System.out.println("view >> "+findByIdAndName);
		
		Employee emp=EmployeeHashMap.getEmployee(findByIdAndName);
		
		/*
		 * Map<String, String> uriVariable= new HashMap<>();
		 * uriVariable.put("empId",findByIdAndName);
		 * 
		 * //ResponseEntity<Project> responseEntity=new
		 * RestTemplate().getForEntity("http://localhost:4444/getProject/{empId}",
		 * Project.class,uriVariable);
		 * 
		 * System.out.println("Service Name :::: "+app.getServiceName()); Application
		 * application = eurekaClient.getApplication(app.getServiceName()); InstanceInfo
		 * instanceInfo = application.getInstances().get(0); String url = "http://" +
		 * instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/" +
		 * "getProject/{empId}"; System.out.println("URL" + url);
		 * ResponseEntity<Project> responseEntity= restTemplate.getForEntity(url,
		 * Project.class,uriVariable); Project response=responseEntity.getBody();
		 * 
		 * emp.setPrjName(response.getProjectName());
		 * emp.setRole(response.getEmpRole());
		 */
			
	        System.out.println("RESPONSE " + emp);
		return emp;
	}
}
