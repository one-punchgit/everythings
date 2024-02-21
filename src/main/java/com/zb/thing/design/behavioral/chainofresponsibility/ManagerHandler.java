package com.zb.thing.design.behavioral.chainofresponsibility;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

@Slf4j
public class ManagerHandler implements Handler {
    public Boolean process(Request request) {
        // 如果超过1000元，处理不了，交下一个处理:
        if (request.getAmount().compareTo(BigDecimal.valueOf(1000)) > 0) {
            return null;
        }
        // 对Bob有偏见:
        if (request.getName().equals("Bob")) {
            log.info("{}审批未通过");
            return false;
        }
        log.info("{}审批通过-manager",request.getName());
        return true;
    }
}