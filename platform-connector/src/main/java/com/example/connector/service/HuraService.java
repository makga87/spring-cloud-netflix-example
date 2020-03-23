package com.example.connector.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class HuraService {
	
	
	@HystrixCommand(fallbackMethod = "exceptionHandler", commandProperties= {
			@HystrixProperty(name="metrics.rollingStats.timeInMilliseconds", value="1000000"), // 서킷 브레이커가 발동할 조건을 체크하는 시간. (얼마간 요청을 수집하여 통계를 낼 것인지) 
			@HystrixProperty(name="circuitBreaker.errorThresholdPercentage", value="30"), // 서킷 브레이커가 발동할 에러 퍼센트 지정, 에러건수/총요청건수 * 100 
			@HystrixProperty(name="circuitBreaker.requestVolumeThreshold", value="5"), // 서킷 브레이커가 열리기 위한 최소 요청 조건, ex) 10초안에 5회가 실패할 경우. 서킷브레이커가 열림. 5회일 경우, 열리지 않음.
			@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value="5000"), // 메서드의 타임아웃 지정, 해당 시간내에 메서드가 완료되지 못하면, 서킷브레이커가 닫혀 있어도 fallback 메서드 호출.
			@HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds", value="10000") // 서킷브레이커가 열렸을 경우, 얼마나 지속될지를 설정. 이는 half open으로 이후 1개의 요청을 받아본 후, 해당 요청이 다시 실패하면 시간은 재연장된다.
	})
	public String connectHuraPlatform() throws JsonMappingException, JsonProcessingException{
		return new RestTemplate().getForEntity("http://localhost:8086/hura-platform/connect", String.class).getBody();
	}
	
	
	// 반드시 Hystrix가 적용된 메서드에 있는 변수명을 일치시켜줘야함.
	public String exceptionHandler(Throwable t) {
			return "예외발생";
	}
	
}
