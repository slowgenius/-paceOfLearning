package com.slowgenius.designPatterns.creationalPatterns.clonePattern;

import java.io.Serializable;

/**
 * @author slowgenius
 * @date 2/17/2020 3:50 PM
 * @description
 */
public class Teacher implements Serializable {
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
}
