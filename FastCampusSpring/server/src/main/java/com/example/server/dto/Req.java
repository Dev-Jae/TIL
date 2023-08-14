package com.example.server.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor // 모든 필드 값에 대한 생성자를 생성
@NoArgsConstructor  // 파라미터가 없는 기본 생성자 생성
public class Req<T> {

    private Header header;
    private T resBody;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Header{
        private String responseCode;
    }
}
