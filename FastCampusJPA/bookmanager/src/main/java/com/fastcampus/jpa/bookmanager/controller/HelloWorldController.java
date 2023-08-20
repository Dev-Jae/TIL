package com.fastcampus.jpa.bookmanager.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * packageName : com.fastcampus.jpa.bookmanager.controller
 * fileName : HelloWorldController
 * author : jae
 * date  : 2023/08/20
 * description :
 * ==========================================================
 * DATE                 AUTHOR                  NOTE
 * ==========================================================
 * 2023/08/20              jae                 최초생성
 */

@Slf4j
@RestController
public class HelloWorldController {

    @GetMapping("/hello-world")
    public String helloWorld(){
        return "hello-world";
    }

}
