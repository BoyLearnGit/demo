package com.example.demo.test;

import java.util.Random;

/**
 * @Desc
 * @Author lyl
 * @Date 2019/3/12 14:53
 **/
public class RandomTest {
    public static void main(String[] args) {
        Random random=new Random();
        for(int i=0;i<10;i++){
            int a=random.nextInt(10);
            System.out.println(a);
        }

//        for(int i=0;i<10;i++) {
//            int b=(int)(Math.random()*1000);
//            System.out.println(b);
//        }

    }
}
