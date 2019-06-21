package com.example.demo.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Desc
 * @Author lyl
 * @Date 2019/3/13 11:31
 **/
public class Mythread implements Runnable{

    public static volatile AtomicInteger count=new AtomicInteger(0);
    @Override
    public void run() {
        while(count.get()<100){
            if(count.get()%2==0&&Thread.currentThread().getName().equals("线程一")){
                System.out.println(Thread.currentThread().getName()+":"+count.get());
                count.getAndIncrement();
            }else if(count.get()%2==1&&Thread.currentThread().getName().equals("线程二")){
                System.out.println(Thread.currentThread().getName()+":"+count);
                count.getAndIncrement();
            }
        }
    }


}
