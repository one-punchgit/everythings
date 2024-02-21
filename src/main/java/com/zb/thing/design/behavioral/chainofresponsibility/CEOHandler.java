package com.zb.thing.design.behavioral.chainofresponsibility;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

@Slf4j
public class CEOHandler implements Handler{
    @Override
    public Boolean process(Request request) {
        if (request.getAmount().compareTo(BigDecimal.valueOf(3000)) > 0) {
            return null;
        }
        // 对Bob有偏见:
        if(request.getName().equals("Bob")){
            log.info("{}审批未通过");
            return false;
        }
        log.info("{}审批通过-ceo",request.getName());
        return true;
    }
}
