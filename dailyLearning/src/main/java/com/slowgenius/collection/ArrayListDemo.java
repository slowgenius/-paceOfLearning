package com.slowgenius.collection;

import org.junit.Test;

import java.util.*;

/**
 * @author slowgenius
 * @date 2/26/2020 11:55 AM
 * @description
 */
public class ArrayListDemo {

    @Test
    public void demo1() {
        ArrayList<Integer> arrayList = new ArrayList<>(100);
        System.out.println(arrayList.size());
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        System.out.println(arrayList.get(1));
        arrayList.add(1, 3);
        System.out.println(arrayList.get(1));
        System.out.println(arrayList.get(2));

        ArrayList arrayList1 = new ArrayList();
        arrayList1.add("slowgenius");
        arrayList1.add(1);

        System.out.println(arrayList.addAll(arrayList1));
        System.out.println(arrayList);

        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7};
        int[] newArr = new int[arr.length];
        //System.arraycopy(newArr,2,arr,3,arr.length-2);

        for (int i : arr) {
            System.out.println(i);
        }

        arrayList.ensureCapacity(100);
        System.out.println("=======");
        System.out.println(4 << 1);

        Vector vector = new Vector();

        HashSet set = new HashSet();
        System.out.println(4 ^ 10);


    }


    @Test
    public void demo2() {
        ArrayList arr = new ArrayList((2 << 22) + 1);
        for (int i = 0; i < (2 << 22)-2; i++) {
            arr.add(i);
        }
        long startArr = System.currentTimeMillis();
        System.out.println("startArr = " + startArr);
        //arr.add(5000000, 2);
        arr.add(1);
        long endArr = System.currentTimeMillis();
        System.out.println("endArr = " + endArr);
        System.out.println(endArr - startArr);

        long startArr1 = System.currentTimeMillis();
        System.out.println("startArr1 = " + startArr1);
        //arr.add(5000000, 2);
        arr.add(1);
        long endArr1 = System.currentTimeMillis();
        System.out.println("endArr1 = " + endArr1);
        System.out.println(endArr1 - startArr1);

//        LinkedList linkedList = new LinkedList();
//        for (int i = 0; i < 10000000; i++) {
//            linkedList.addLast(i);
//        }
//
//        long startLinked = System.currentTimeMillis();
//        System.out.println("startLinked = " + startLinked);
//        linkedList.add(1,9999999);
//        long endLinked = System.currentTimeMillis();
//        System.out.println("endLinked = " + endLinked);
//
//        System.out.println(endLinked - startLinked);

    }

}
