package com.example.objectmapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ObjectMapperApplicationTests {

    @Test
    void contextLoads() throws JsonProcessingException {
        System.out.println("------------");

        // object-mapper
        // Text JSON -> Object
        // Object -> Text JSON

        // controller req json(text) -> object
        // response object -> json(text)

        var objectMapper = new ObjectMapper();

        // object -> text
        // object mapper get method를 활용
        // object 에 get이 들어간 다른 method가 있으면 안됨
        var user = new User("chu", 30, "010-1111-2222");
        var text = objectMapper.writeValueAsString(user);
        System.out.println(text);

        // text -> object
        // object mapper는 dafault 생성자를 필요로 함
        var objectUser = objectMapper.readValue(text, User.class);
        System.out.println(objectUser);
    }

}
