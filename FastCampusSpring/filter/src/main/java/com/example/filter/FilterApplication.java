package com.example.filter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan	// 서블릿 컴포넌트(필터, 서블릿, 리스너)를 스캔해서 빈으로 등록
// 다만 해당 서블릿 컴포넌트 클래스에는 필터, 서블릿, 리스너 어노테이션이 추가되어 있어야 함
public class FilterApplication {
	/*
	  Filter : Web Application에서 관리되는 영역
	  Spring Boot Framework에서 Client로 부터 오는 요청/응답에 대해서 최초/최종 단계의 위치에 존재
	  이를 통해 요청/응답의 정보를 변경하거나, Spring에 의해서 데이터가 변환되기 전의 순수한 Client의 요청/응답 값을 확인 할 수 있음
	  유일하게 ServletRequest, ServletResponse의 객체를 변환 할 수 있음
	  주로 request / response 의 logging 용도로 활용하거나, 인증과 관련된 Logic들을 Filter에 처리
	  이를 선/후 처리 함으로써 Service business login과 분리 시킴
	 */
	public static void main(String[] args) {
		SpringApplication.run(FilterApplication.class, args);
	}

}
