package com.example.validation.validator;

import com.example.validation.annotation.YearMonth;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// ConstraintValidator : 제약조건 Contraint에 대한 유효성 검증 로직 정의
public class YearMonthValidator implements ConstraintValidator<YearMonth, String> {

    private String pattern;

    @Override
    public void initialize(YearMonth constraintAnnotation) {    // isValid 메서드를 호출하기 전에 해당 ConstraintValidator를 초기화
        this.pattern = constraintAnnotation.pattern();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // 실제 검증 대상 객체를 이용해 유효성 검증 로직 실행하여 유효성 검증 성공 여부 반환
        // yyyyMM01
        try {
            LocalDate localDate = LocalDate.parse(value+"01", DateTimeFormatter.ofPattern(this.pattern));
        } catch (Exception e){
            return false;
        }

        return true;
    }
}
