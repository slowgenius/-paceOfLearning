package com.slowgenius.cap8.bean;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author slowgenius
 * @date 2/22/2020 7:46 PM
 * @description
 */
public class Bird {


    @Value("bird")
    private String name;

    @Value("#{10-2}")
    private Integer age;

    @Value("${bird.color}")
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Bird(String name, Integer age, String color) {
        this.color = color;
        this.name = name;
        this.age = age;
    }

    public Bird(){
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Bird{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}
