package com.zb.thing.basic.pojo;

import lombok.Data;

@Data

public class User1 {
    private Integer id;
    private String name;
    public User1(){

    }

    public User1(Integer id,String name){
        this.id = id;
        this.name  = name;
    }
}
