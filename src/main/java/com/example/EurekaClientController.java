package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EurekaClientController {
	@Autowired
	private DiscoveryClient discoveryClient;

	@ResponseBody
	@RequestMapping("/client/{applicationName}")
	public List<ServiceInstance> client(@PathVariable String applicationName) {
		return this.discoveryClient.getInstances(applicationName);
	}
}
