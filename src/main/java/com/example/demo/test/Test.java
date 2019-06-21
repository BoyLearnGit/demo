package com.example.demo.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Test {

    private static int b;

    public static void main(String[] args) {

//        Arrays.stream(new int[]{1,2,3,4})
//                .map(val->val+1)
//                .forEach(System.out::println);
//        List list=Arrays.asList(new String[]{"1","2","3","4"});
//        list.forEach((e)-> System.out.println(e));
//        list.stream().filter((e)->!e.equals("1")).map(e->e+"hah").forEach(System.out::println);
//        Runnable r=()-> {
//            try {
//                Thread.sleep(10000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("haha");
//        r.run();
//    };
        String str = ",1,2,3, , ,";
        String[] arr = str.split(",", 2);
        System.out.println(arr.length);
        System.out.println("第一个逗号的位置是：" + str.indexOf(",2"));
        System.out.println("截取字符串"+str.substring(2,4));
        System.out.println("截取字符串"+str.substring(2));
        Arrays.stream(arr).forEach(e -> System.out.println("+" + e + "+"));


    }
}
