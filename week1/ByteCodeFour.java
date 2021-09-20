package com.tgt.common.week01;

public class ByteCodeFour {
    public static void main(String[] args) {
        int num = 10;
        double dnum= 2D;
        long l= 1L;
        boolean b= false;  //在JVM中布尔类型是用int类型来存储的，所以声明的这个布尔值在字节码中表示为：iconst_0
                                                                                        //istore

        if(num>0){
            b=true;
        }else{
            b=false;
        }

        for (int i = 0; i < num; i++) {
            System.out.println((num+i) * dnum);  //字节码中算术操作和类型转换，byte:1个，short：2个，int：4个，long：8个，float：8个，double：16个
                                                //从低到高可以转换，从高到底则不可以，所以这边（num+i）*dnum 字节码里面是i2d而不是d2i
        }
    }
}
