package com.example.swagger.controller;

import com.example.swagger.dto.UserReq;
import com.example.swagger.dto.UserRes;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

// http://localhost:8080/swagger-ui/
@Api(tags = {"API 정보를 제공하는 Controller"})    // 클래스를 swagger의 리소스로 표시
@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @ApiImplicitParams({    // 메소드 단위의 오퍼레이션 파라미터를 설명
            @ApiImplicitParam(name = "x",value = "x값", required = true, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "y", value = "y값", required = true, dataType = "int", paramType = "query")
    })
    @GetMapping("/plus/{x}")
    public int plus(@PathVariable int x, @RequestParam int y){
        return x + y;
    }

    @ApiResponse(code = 502, message = "사용자의 나이가 10살 이하일때") // 오퍼레이션의 응답 지정
    @ApiOperation(value = "사용자의 이름과 나이를 리턴하는 메소드")  // 특정 경로의 오퍼레이션 HTTP 메소드 설명
    @GetMapping("/user")
    public UserRes user(UserReq userReq){
        return new UserRes(userReq.getName(), userReq.getAge());
    }

    @PostMapping("/user")
    public UserRes userPost(@RequestBody UserReq req){
        return new UserRes(req.getName(), req.getAge());
    }
}
