package com.tgt.common.bean;

import java.util.List;

public class Boy {
    public Boy(){

    }
    public String show(){
        if(name!=null&&name!=""){
            return "i'm a boy named "+name;
        }
        if(names!=null){
            String res="i'm a boy named ";
            for(int i=0;i<names.size();i++){
                res+=names.get(i)+",";
            }
            return res;
        }
        return "i'm a boy";
    }

    private String name;
    public Boy(String name){
        this.name=name;
    }
    private List<String> names;
    public Boy(List<String> names){
        this.names=names;
    }
}