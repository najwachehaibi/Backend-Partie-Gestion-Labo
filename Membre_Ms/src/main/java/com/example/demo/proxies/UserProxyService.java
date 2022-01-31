package com.example.demo.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.beans.UserBean;




	@FeignClient(name="USER-SERVICE")
	public interface UserProxyService {
		@GetMapping(value = "/User/{id}")
		public UserBean findOneUserById(@PathVariable(name = "id") Long id);

}
