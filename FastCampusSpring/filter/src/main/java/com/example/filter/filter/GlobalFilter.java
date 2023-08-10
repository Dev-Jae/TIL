package com.example.filter.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@Slf4j // 로깅에 대한 추상 레이어를 제공하는 인터페이스의 모음
@WebFilter(urlPatterns = "/api/user/*") // 특정 컨트롤러에만 필터를 적용시키고 싶을 때 사용, 배열로 설정 가능
public class GlobalFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 전처리
/*      HttpServletRequest httpServletRequest = (HttpServletRequest)request;
        HttpServletResponse httpServletResponse = (HttpServletResponse)response;*/
        ContentCachingRequestWrapper httpServletRequest = new ContentCachingRequestWrapper((HttpServletRequest)request);
        ContentCachingResponseWrapper httpServletResponse = new ContentCachingResponseWrapper((HttpServletResponse)response);

        // 커서단위로 읽게되는데 커서가 라인의 제일 끝으로가 바디를 다 읽어버린 상태
        // 이렇게 bufferedReader를 사용해 읽어버리면 클라이언트 요청에 대해서 다른곳에서 읽을수가 없음
        // ContentCachingRequestWrapper를 사용하면 캐싱을 할 수 있기에 읽을수 있음
/*
        BufferedReader br = httpServletRequest.getReader();
        br.lines().forEach(line -> {
            log.info("url : {}, line : {}", url, line);
        });
*/
        chain.doFilter(httpServletRequest, httpServletResponse);

        String url = httpServletRequest.getRequestURI();
        // 후처리
        // req
        String reqContent = new String(httpServletRequest.getContentAsByteArray());

        log.info("request url : {}, requestBody : {}", url, reqContent);

        String resContent = new String(httpServletResponse.getContentAsByteArray());
        int httpStatus = httpServletResponse.getStatus();

        // getContentAsByteArray 호출함으로써 바디에 있는 내용을 빼버려서 다시 채워줘야함
        // copyBodyToResponse 메소드를 호출해야 클라이언트가 제대로 된 응답을 받을 수 있음
        httpServletResponse.copyBodyToResponse();

        log.info("response status : {}, requestBody : {}", httpStatus, resContent);

    }
}
