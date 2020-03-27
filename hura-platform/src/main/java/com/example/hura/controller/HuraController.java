package com.example.hura.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hura-platform")
public class HuraController {

	private int requestCnt;
	@Value("${spring.application.name}")
	private String appName;
	
	@RequestMapping("/connect")
	public String connect() throws Exception {

		System.out.println("requestCnt : " + requestCnt);
		if(requestCnt % 2 == 0) {
			requestCnt ++;
			return "요청 성공";
		} else {
			Thread.sleep(7000);
			requestCnt ++;
			throw new RuntimeException();
		}
	}
}
