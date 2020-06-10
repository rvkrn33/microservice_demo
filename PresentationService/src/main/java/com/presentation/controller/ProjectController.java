package com.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.presentation.dto.Employee;
import com.presentation.dto.Project;
import com.presentation.utility.ProjectHashMap;

@RestController
public class ProjectController {
	
	 @Autowired
	 private AppProperties app;
	 @Autowired
	    private RestTemplate restTemplate;
	    @Autowired
	    private EurekaClient eurekaClient;
	
	@GetMapping("/getProject/{empId}")
	public Project getProject(@PathVariable long empId) {
		System.out.println("Get Request >>> "+empId);
		return ProjectHashMap.getProject(empId);
	}
	
	@PostMapping("/addEmp")
	public Employee saveEmployee(@RequestBody Employee empData) {
		
		 ProjectHashMap.assignProject(empData);
	        
		Project project=ProjectHashMap.getProject(empData.getEmpId());
			
		empData.setPrjName(project.getProjName());
		empData.setRole(project.getEmpRole());
			
		System.out.println("Service Name :::: "+app.getServiceName());
		 Application application = eurekaClient.getApplication(app.getServiceName());
	     InstanceInfo instanceInfo = application.getInstances().get(0);
	        String url = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/" + "addEmp";
	        System.out.println("URL" + url);
	        
	        ResponseEntity<Employee> responseEntity= restTemplate.postForEntity(url, empData,Employee.class); 
	        Employee empResponse=responseEntity.getBody();
			  
	        System.out.println("Get Request >>> "+empResponse.getEmpId());
	        
	       
	        System.out.println("RESPONSE " + empResponse);

		return empResponse;
	}
		
}
