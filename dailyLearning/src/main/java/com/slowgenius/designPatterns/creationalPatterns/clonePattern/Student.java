package com.slowgenius.designPatterns.creationalPatterns.clonePattern;

import java.io.Serializable;

/**
 * @author slowgenius
 * @date 2/17/2020 11:21 AM
 * @description
 */
public class Student implements Serializable,Cloneable {

    private Teacher teacher;

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Student() {
        super();
    }
    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
