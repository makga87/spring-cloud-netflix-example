package com.example.status.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status")
public class StatusController {

	@Value("${spring.application.name}")
	private String appName;
	
	@Value("${server.port}")
	private int port;

	@RequestMapping("/day")
	public Map<String, Object> getDayStatus(){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("day", "1093kwh");
		resultMap.put("result", true);
		resultMap.put("msg", "response success");
		resultMap.put("appName", appName);
		resultMap.put("port", port);
		return resultMap;
	}
}
