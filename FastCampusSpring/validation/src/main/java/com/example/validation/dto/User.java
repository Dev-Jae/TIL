package com.example.validation.dto;

import com.example.validation.annotation.YearMonth;
import org.springframework.boot.autoconfigure.web.format.DateTimeFormatters;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class User {
    // Custom Validation
    // 1. AssertTrue / False 와 같은 method 지정을 통해서 Custom Logic 적용 가능
    // 2. ConstraintValidator를 적용하여 재사용이 가능한 Custom Logic 적용 가능
    private String name;
    @Max(value = 90)
    private int age;
/*    @Email
    private String email;
    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "핸드폰 번호의 양식과 맞지 않습니다. 01x-xxx(x)-xxxx")
    private String phoneNumber;

    @YearMonth
    private String reqYearMonth; // yyyyMM*/

    @Valid
    private List<Car> cars;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", cars=" + cars +
                '}';
    }
}
