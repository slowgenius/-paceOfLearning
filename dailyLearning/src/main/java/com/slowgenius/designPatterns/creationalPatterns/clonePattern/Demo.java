package com.slowgenius.designPatterns.creationalPatterns.clonePattern;

import java.io.*;

/**
 * @author slowgenius
 * @date 2/17/2020 11:27 AM
 * @description
 */
public class Demo {
    /**
     * 浅克隆
     */
    public static void demo1() throws CloneNotSupportedException {
        Student student = new Student();
        student.setId(1);
        student.setName("slowgenius");
        Teacher teacher = new Teacher();
        teacher.setId(1);
        teacher.setName("teacher");
        student.setTeacher(teacher);

        Student studentCopy = (Student) student.clone();
        System.out.println(student == studentCopy);
        System.out.println(student.getTeacher() == studentCopy.getTeacher());
    }

    /**
     * 深克隆
     */
    public static void demo2() throws IOException, ClassNotFoundException {
        Student student = new Student();
        Teacher teacher = new Teacher();
        teacher.setName("teacher");
        teacher.setId(2);
        student.setTeacher(teacher);
        student.setName("slowgenius");
        student.setId(1);
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream objectOut = new ObjectOutputStream(byteOut);
        objectOut.writeObject(student);

        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
        ObjectInputStream objectIn = new ObjectInputStream(byteIn);

        Student studentCopy = (Student) objectIn.readObject();
        System.out.println(studentCopy == student);
        System.out.println(student.getTeacher() == studentCopy.getTeacher());

    }

    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        demo2();
    }
}
