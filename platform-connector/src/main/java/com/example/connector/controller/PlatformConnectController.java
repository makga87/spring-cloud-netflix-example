package com.example.connector.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.connector.service.HuraService;
import com.example.connector.vo.ResultVo;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/platform")
public class PlatformConnectController {
	
	@Autowired
	private HuraService service;

	@RequestMapping("/")
	public void test() {
		System.out.println("test");
	}
	
	@RequestMapping("/connect/hura")
	public HashMap<String, Object> connecHura() throws JsonMappingException, JsonProcessingException{

		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		long startTime = System.currentTimeMillis();
		String result = service.connectHuraPlatform();
		long endTime = System.currentTimeMillis();
		
		resultMap.put("msg", result);
		resultMap.put("returnTime", endTime-startTime);
		return resultMap;
	}
}
