package com.domain.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties("presentation-service-name")
public class AppProperties {

	private String serviceName;

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

			
}
