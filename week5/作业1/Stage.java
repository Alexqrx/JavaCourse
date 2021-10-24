package com.tgt.common.bean;

public class Stage {
    private Stage() {

    }
    public String show(){
        return "i'm stage";
    }
    private static class F{
        static Stage sta= new Stage();
    }

    public static Stage getInstance(){
        return F.sta;
    }
}