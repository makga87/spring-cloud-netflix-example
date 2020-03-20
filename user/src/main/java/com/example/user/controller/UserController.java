package com.example.user.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

	@Value("${spring.application.name}")
	private String appName;
	
	
	@RequestMapping("/login/{userId}")
	public Map<String, Object> login(@PathVariable(value="userId") String userId){
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("userId", userId);
		resultMap.put("result", true);
		resultMap.put("msg", "login success");
		resultMap.put("appName", appName);
		return resultMap;
	}
}
