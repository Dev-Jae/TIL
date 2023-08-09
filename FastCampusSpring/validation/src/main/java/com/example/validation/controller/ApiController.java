package com.example.validation.controller;

import com.example.validation.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class ApiController {

    @PostMapping("/user")
    public ResponseEntity user(@Valid @RequestBody User user, BindingResult bindingResult){
        // BindingResult는 검증 오류가 발생할 경우 오류 내용을 보관하는 스트링 프레임워크에서 제공하는 객체
       if(bindingResult.hasErrors()){   // hasError() : BindingResult는에 에러가 있는지 검사하는 메서드
           StringBuilder sb = new StringBuilder();
           bindingResult.getAllErrors().forEach(objectError -> {
               FieldError field = (FieldError) objectError;
               String message = objectError.getDefaultMessage();

               System.out.println("field : " + field.getField());
               System.out.println(message);

                sb.append("field : " + field.getField());
                sb.append("message : " + message);
           });

           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sb.toString());
       }

        return ResponseEntity.ok(user);
    }
}
