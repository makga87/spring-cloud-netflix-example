package com.example.customer.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cs")
public class CustomerServiceController {
	@Value("${spring.application.name}")
	private String appName;

	@RequestMapping("/faq")
	public Map<String, Object> getDayStatus(){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result", true);
		resultMap.put("msg", "good");
		resultMap.put("appName", appName);
		return resultMap;
	}
}
