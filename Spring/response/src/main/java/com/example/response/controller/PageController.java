package com.example.response.controller;

import com.example.response.dto.UserDto;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {

    @RequestMapping("/main")
    public String main(){
        return "main.html";
    }

    // JSON
    // ResponseEntity
    @ResponseBody
    @GetMapping("/user")
    public UserDto user(){
        var user = new UserDto();
        user.setName("chu");
        user.setAddress("chu's home");
        return user;
    }
}
