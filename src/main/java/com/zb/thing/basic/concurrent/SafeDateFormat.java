package com.zb.thing.basic.concurrent;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class SafeDateFormat {

    static final ThreadLocal<DateFormat> tl = new ThreadLocal();


    public static DateFormat get(){
        tl.remove();
        return tl.get();
    }
    public static void set(String tes){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(tes);
        System.out.println(simpleDateFormat.toString());
        tl.set(simpleDateFormat);
    }

}
