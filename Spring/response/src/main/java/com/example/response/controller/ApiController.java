package com.example.response.controller;

import com.example.response.dto.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {

    // TEXT
    @GetMapping("/text")
    public String test(@RequestParam String account){

        return account;
    }

    // JSON
    // req -> object mapper -> object -> method -> object -> object mapper -> json -> response
    @PostMapping("/json")
    public UserDto json(@RequestBody UserDto user){
        return user; // 200 OK
    }

    // ResponseEntity
    @PutMapping("/put")
    public ResponseEntity<UserDto> put(@RequestBody UserDto user){
        // 응답에 대한 커스텀마이징이 필요할 때 ResponseEntity
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
