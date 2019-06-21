package com.example.demo.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Desc
 * @Author lyl
 * @Date 2019/3/13 11:29
 **/
public class RoundRobinPrint {

    public static void main(String[] args) {
        Mythread mya=new Mythread();
        Thread a=new Thread(mya);
        a.setName("线程一");
        a.start();
        Mythread myb=new Mythread();
        Thread b=new Thread(myb);
        b.setName("线程二");
        b.start();

    }
}
