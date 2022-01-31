package com.example.demo.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.beans.EventBean;

	
	@FeignClient(name="EVENEMENT-SERVICE")
	public interface EventProxyService {
		@GetMapping(value = "/event/{id}")
		public EventBean findOneEventById(@PathVariable(name = "id") Long id);

}
