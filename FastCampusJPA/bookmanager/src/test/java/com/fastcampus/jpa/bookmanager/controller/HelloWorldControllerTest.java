package com.fastcampus.jpa.bookmanager.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * packageName : com.fastcampus.jpa.bookmanager.controller
 * fileName : HelloWorldControllerTest
 * author : jae
 * date  : 2023/08/20
 * description :
 * ==========================================================
 * DATE                 AUTHOR                  NOTE
 * ==========================================================
 * 2023/08/20              jae                 최초생성
 */

@WebMvcTest
class HelloWorldControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void helloWorld() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/hello-world"))
                .andDo(print())                 // MockMvcResultHandlers.print() : 요청에 대한 응답을 콘솔에 출력
                .andExpect(status().isOk())     // MockMvcResultMatchers.status().isOk() : status 코드가 200임을 확인
                .andExpect(content().string("hello-world"));    // MockMvcResultMatchers.content().string("~")  // 결과읜 컨텐트가 string형 ~임음 확인
    }

}