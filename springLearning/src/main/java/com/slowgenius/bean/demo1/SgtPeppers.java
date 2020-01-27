package com.slowgenius.bean.demo1;

import org.springframework.stereotype.Component;

/**
 * @author slowgenius
 * @date 1/27/2020 1:08 PM
 * @description
 */

@Component
public class SgtPeppers implements CompactDisc {

    private String content = "play something";
    @Override
    public void play() {
        System.out.println("Sgt pepper " + content);
    }
}
