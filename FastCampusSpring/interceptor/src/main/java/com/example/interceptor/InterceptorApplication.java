package com.example.interceptor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InterceptorApplication {
	/*
	   Interceptor란 Filter와 매우 유사한 형태로 존재 하지만, 차이점은 Spring Context에 등록됨
	   AOP와 유사한 기능을 제공 할 수 있으며, 주로 인증 단계를 처리하거나 Logging을 하는 데에 사용
	   이를 선/후 처리 함으로써 Service business logic과 분리 시킴
	 */

	public static void main(String[] args) {
		SpringApplication.run(InterceptorApplication.class, args);
	}

}
