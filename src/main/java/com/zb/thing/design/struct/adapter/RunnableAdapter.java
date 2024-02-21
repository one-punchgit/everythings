package com.zb.thing.design.struct.adapter;

import java.util.concurrent.Callable;

public class RunnableAdapter implements Runnable{
    private Callable callable;

    public RunnableAdapter(Callable callable){
        this.callable = callable;
    }

    @Override
    public void run() {
        try {
            this.callable.call();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
