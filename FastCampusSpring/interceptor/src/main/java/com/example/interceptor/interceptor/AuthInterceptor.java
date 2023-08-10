package com.example.interceptor.interceptor;

import com.example.interceptor.annotation.Auth;
import com.example.interceptor.exception.AuthException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;

@Slf4j
@Component  // 직접 개발한 클래스를 Bean으로 등록하고자 할때 사용
public class AuthInterceptor implements HandlerInterceptor {
    /*
    HandlerInterceptor : 특정한 URI 호출을 '가로채는' 역할
    기존 컨트롤러의 로직을 수정하지 않고, 사전이나 사후에 제어 가능
    Filter와의 차이는 두 기능 모두 특정 URI에 접근할 때 제어하는 용도로 사용되지만 Context(실행영역)에 차이가 있음
    Filter 는 웹 어플리케이션 내에서 동작하기 때문에 Spring Context에 접근하기 어려움
    Interceptor의 경우 Spring 영역 내에서 동작하기 때문에, Spring Context에 접근하기 용이
    Spring Context : Bean의 확장 버전으로 Spring이 Bean을 다루기 좀 더 쉽도록 기능들이 추가된 공간
    */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /*
         preHandle : 지정된 컨트롤러의 동작 이전에 수행할 동작(사전 제어)
         UriComponentsBuilder : UriComponents를 build할 수 있도록 도와주는 클래스
         UriComponents : URI를 구성하는 Components들을 효과적으로 다룰 수 있도록 하는 클래스
         Object 형 handler 인자는 RequestMapping으로 매핑된 하나의 메소드로 스프링 프레임워크에 의해
         org.springframework.web.method.HandlerMethod라는 클래스로 바인드 되어 전달되는 인자
         getMethod()를 호출하면 실제 java Reflection의 Method형 객체를 얻을 수 있음
         */
        String url = request.getRequestURI();
        URI uri = UriComponentsBuilder.fromUriString(url)
                .query(request.getQueryString())
                .build()
                .toUri();

        log.info("request url : {}", url);
        boolean hasAnnotation = checkAnnotation(handler, Auth.class);
        log.info("has annotation : {}", hasAnnotation);

        // 나의 서버는 모두 public 으로 동작을 하는데
        // 단! Auth 권한을 가진 요청에 대해서는 세션, 쿠키 등 값을 체크
        if(hasAnnotation){
            // 권한 체크
            String query = uri.getQuery();
            log.info("query : {}", query);
            if(query.equals("name=chu")){
                return true;
            }

            // 권한 없으면 던짐
            throw new AuthException();
        }


        return true;
    }

    private boolean checkAnnotation(Object handler, Class clazz){

        // resourcem javascript, html 등 통과
        if(handler instanceof ResourceHttpRequestHandler){
            return true;
        }

        // annotation check
        HandlerMethod handlerMethod = (HandlerMethod) handler;  // 커스텀 어노테이션을 가져오기 위해 선언
        if(null != handlerMethod.getMethodAnnotation(clazz) || null != handlerMethod.getBeanType().getAnnotation(clazz)){
            // Auth annotation 있을 때는 true
            return true;
        }

        return false;
    }
}
