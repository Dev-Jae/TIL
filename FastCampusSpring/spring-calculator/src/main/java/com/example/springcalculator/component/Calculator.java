package com.example.springcalculator.component;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor    // 필드 주입 생성자를 대체해줌
public class Calculator {
    private final ICalculator iCalculator;

    public int sum(int x, int y){
        this.iCalculator.init();
        return this.iCalculator.sum(x, y);
    }

    public int minus(int x, int y){
        this.iCalculator.init();
        return this.iCalculator.minus(x, y);
    }

}
