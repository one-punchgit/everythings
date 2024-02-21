package com.zb.thing.design.behavioral.chainofresponsibility;

import java.math.BigDecimal;

/**
 * 责任链模式（Chain of Responsibility）是一种处理请求的模式，它让多个处理器都有机会处理该请求，直到其中某个处理成功为止。责任链模式把多个处理器串成链，然后让请求在链上传递
 */
public class Test {
    public static void main(String[] args) {
        Request request1 = new Request("zb1", new BigDecimal(1000));
        Request request2 = new Request("zb2", new BigDecimal(2000));
        Request request3 = new Request("zb3", new BigDecimal(3000));
        Request request4 = new Request("zb4", new BigDecimal(4000));


        HandlerChain handlerChain = new HandlerChain();
        ManagerHandler managerHandler = new ManagerHandler();
        DirectorHandler directorHandler = new DirectorHandler();
        CEOHandler ceoHandler = new CEOHandler();

        handlerChain.add(managerHandler);
        handlerChain.add(directorHandler);
        handlerChain.add(ceoHandler);

        handlerChain.process(request1);
        handlerChain.process(request2);
        handlerChain.process(request3);
        handlerChain.process(request4);

    }
}
