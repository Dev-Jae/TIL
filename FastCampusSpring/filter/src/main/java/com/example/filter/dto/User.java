package com.example.filter.dto;

import lombok.*;

@Data   // lombok @Getter, @Setter, toString 등.. 다 만들어줌
@NoArgsConstructor  // 기본 생성자
@AllArgsConstructor // 전체 생성자
public class User {
    private String name;
    private int age;
}
