package com.example.springcalculator.controller;

import com.example.springcalculator.component.Calculator;
import com.example.springcalculator.component.DollarCalculator;
import com.example.springcalculator.component.ICalculator;
import com.example.springcalculator.component.MarketApi;
import com.example.springcalculator.dto.Req;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
/*
 *  @WebMvcTest : Application Context를 완전하게 Start 시키지 않고 Web layer를 테스트 하고 싶을때 사용
 *  @@SpringBootTest : 모든 빈을 로드하기 때문에 테스트 구동 시간이 오래 걸리고, 테스트 단위가 크기 때문에 디버깅이 어려울 수 있음
 *  Controller 레이어만 테스트 하고 싶을 때는 @WebMvcTest를 사용하는게 유용
 *  @AutoConfigureWebMvc : MVC와 관련된 Bean을 올림. 추후에 사용할 MockMvc를 Builder 없이 주입할 수 있게 도와줌
 */
@WebMvcTest(CalculatorApiController.class)
@AutoConfigureWebMvc
@Import({Calculator.class, DollarCalculator.class})
public class CalculatorApiControllerTest {

    @MockBean   // 해당 Bean이 붙은 클래스에 관해서 MockContext에 등록
    private MarketApi marketApi;

    @Autowired  // MockMvc의 DI를 주입
    private MockMvc mockMvc;
    // MockMvc : 개발한 웹 프로그랩을 실제 서버에 배포하지 않고 테스트를 하기 위한 요청을 제공하는 수단

    @BeforeEach // 각 @Test가 실핼되기전 행동을 정의
    public void init(){
        Mockito.when(marketApi.connect()).thenReturn(3000);
    }

    @Test
    public void sumTest() throws Exception {
    /*   http://localhost:8080/api/sum
         perform : 요청을 전송하는 역할, 결과로 ResultActions 객체를 받으며,
         ResultActions 객체는 리턴 값을 검증하고 확인 할 수 있는 andExcpect() 메소드 제공
         andExpect : 응답을 검증하는 역할
         MockMvcRequestBuilders : GET, POST, PUT, DELETE 요청 방식과 매핑되는 메소드를 제공
         이 메소드들은 MockHttpServletRequestBuilder 객체를 리턴하고, 이를 통해 HTTP 요청 관련 정보(파라미터, 헤더, 쿠키 등)을
         설정 할 수 있음.
         andDo : 요청에 대한 처리
    */

        mockMvc.perform(
                MockMvcRequestBuilders.get("http://localhost:8080/api/sum")
                        .queryParam("x", "10")
                        .queryParam("y", "10")
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        ).andExpect(
                MockMvcResultMatchers.content().string("60000")
        ).andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void minusTest() throws Exception {
        Req req = new Req();
        req.setX(10);
        req.setY(10);

        String json = new ObjectMapper().writeValueAsString(req);

        mockMvc.perform(
                MockMvcRequestBuilders.post("http://localhost:8080/api/minus")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.result").value("0")
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.response.resultCode").value("OK")
        ).andDo(MockMvcResultHandlers.print());
    }
}
