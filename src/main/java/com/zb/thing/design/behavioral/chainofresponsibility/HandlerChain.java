package com.zb.thing.design.behavioral.chainofresponsibility;

import java.util.ArrayList;
import java.util.List;

public class HandlerChain {
    private List<Handler> handlers = new ArrayList<>();

    public List<Handler> add(Handler handler){
        this.handlers.add(handler);
        return  this.handlers;
    }

    public boolean process(Request request){

        for (Handler handler : handlers) {
            Boolean process = handler.process(request);
            if(process != null){
                return process;
            }
        }
        throw new RuntimeException("无法处理");
    }

}
