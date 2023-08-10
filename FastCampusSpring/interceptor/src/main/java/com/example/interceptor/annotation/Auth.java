package com.example.interceptor.annotation;

import java.lang.annotation.*;

@Documented // javadoc으로 api 문서를 만들 때 어노테이션에 대한 설명도 포함하도록 지정해주는 것
@Retention(RetentionPolicy.RUNTIME) // 어노테이션의 유지 정책 설정 (RUNTIME : 실행시 어노테이션 정보가 가상 머신에 의해서 참조 가능, 자바리플렉션에 의해 사용)
@Target({ElementType.TYPE, ElementType.METHOD}) // 어노테이션을 적용할 수 있는 위치
public @interface Auth {
}
