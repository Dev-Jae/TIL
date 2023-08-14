package com.example.client.service;

import com.example.client.dto.Req;
import com.example.client.dto.UserRequest;
import com.example.client.dto.UserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
@Slf4j
public class RestTemplateService {
    /*
       UriComponents : URI를 구성하는 Components들을 효과적으로 다룰 수 있도록 하는 클래스
       UriComponentsBuilder : UriComponents를 Build할 수 있도록 도와주는 클래스
       RequestEntity : url 요청을 보낼 때 사용, header, body, method, url , type을 생성자 파라미터로 넘길 수 있음
       ResponseEntity : url 요청에 응답할 때 사용, body, header, status를 생성자 파라미터로 넘길 수 있음
     */

    // http://localhost/api/server/hello
    // response
    public UserResponse hello(){
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/hello")
                .queryParam("name", "chu")
                .queryParam("age", 30)
                .encode()
                .build()
                .toUri();

        log.info("uri : {}", uri.toString());

        RestTemplate restTemplate = new RestTemplate(); // 간편하게 Rest 방식 API를 호출할 수 있는 Spring 내장 클래스
        ResponseEntity<UserResponse> result = restTemplate.getForEntity(uri, UserResponse.class);

        log.info("result code : {}", result.getStatusCode());
        log.info("result body : {}", result.getBody());

        return result.getBody();
    }

    public UserResponse post(){
        // http://localhost:9090/api/server/user/{userId}/name/{usernNme}

        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/user/{userId}/name/{userName}")
                .encode()
                .build()
                .expand(100, "chu")
                .toUri();

        log.info("post uri : {}", uri);

        // http body -> object -> object mapper -> json > rest template -> http body json
        UserRequest req = new UserRequest();
        req.setName("chu");
        req.setAge(30);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserResponse> response = restTemplate.postForEntity(uri, req, UserResponse.class);

        log.info("post res status code : {}", response.getStatusCode());
        log.info("post res header : {}", response.getHeaders());
        log.info("post res body : {}", response.getBody());

        return response.getBody();
    }

    public UserResponse exchange(){
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/user/{userId}/name/{userName}")
                .encode()
                .build()
                .expand(100, "chu")
                .toUri();

        log.info("post uri : {}", uri);

        // http body -> object -> object mapper -> json > rest template -> http body json
        UserRequest req = new UserRequest();
        req.setName("chu");
        req.setAge(30);

        RequestEntity<UserRequest> requestEntity = RequestEntity
                .post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .header("x-authorization", "abcd")
                .header("custom-header", "fffff")
                .body(req);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserResponse> response = restTemplate.exchange(requestEntity, UserResponse.class);
        // exchange : HTTP 헤더를 새로 만들 수 있고 어떤 HTTP 메서드도 사용가능
        // Get 요청에 header 값이 필요한 경우 exchange 메소드를 사용해 header 추가

        return response.getBody();
    }

    public Req<UserResponse> genericExchange(){
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/user/{userId}/name/{userName}")
                .encode()
                .build()
                .expand(100, "chu")
                .toUri();

        log.info("post uri : {}", uri);

        // http body -> object -> object mapper -> json > rest template -> http body json
        UserRequest userRequest = new UserRequest();
        userRequest.setName("chu");
        userRequest.setAge(30);

        Req<UserRequest> req = new Req<>();
        req.setHeader(
                new Req.Header()
        );

        req.setResBody(
                userRequest
        );


        RequestEntity<Req<UserRequest>> requestEntity = RequestEntity
                .post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .header("x-authorization", "abcd")
                .header("custom-header", "fffff")
                .body(req);

        RestTemplate restTemplate = new RestTemplate();



        ResponseEntity<Req<UserResponse>> response
                = restTemplate.exchange(requestEntity,  new ParameterizedTypeReference<Req<UserResponse>>(){});
        // ParameterizedTypeReference : Java 단에서 외부 서버의 Rest API로 얻어온 자원을 어떤 타입의 Java object로 변환할지를 미리 지정할 떄 사용

        return response.getBody();
    }
}
