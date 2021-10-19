package com.tgt.common.week04.homework;

public class work4 {
    public static void main(String[] args) throws InterruptedException {
        Object o=new Object();
        Thread t=new Thread(()->{
            int num=100;
            String s="";
            for (int i = 0; i <num ; i++) {
                s+="java";
            }
            System.out.println("t Over");
            synchronized (o){
                System.out.println("执行子线程前");
                o.notify();
                System.out.println("执行子线程后");
            }
            System.out.println("结束线程");
        });
        long start = System.currentTimeMillis();
        System.out.println("start = " + start);
        t.start();
        synchronized (o){
            System.out.println("执行主线程wait前");
            o.wait();
            System.out.println("执行主线程wait后");
        }
        long end = System.currentTimeMillis();
        System.out.println("end"+end);
        System.out.println("end-start"+(end-start));
    }
}
