package com.example.objectmapper;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User{
    private String name;
    private int age;
    @JsonProperty("phone_number")
    private String phoneNumber;

    public User(){}

    public User(String name, int age, String phoneNumber){
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public User defaultUser(){
        return new User("dafault", 0, "010-1111-1111");
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
