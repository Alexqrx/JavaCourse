package com.tgt.common.week04.homework;

public class work1 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(getSum(i));
        }
        //推出主线程
        System.out.println("执行结束");
    }
    public static int getSum(int n){
        return n+1;
    }
}
