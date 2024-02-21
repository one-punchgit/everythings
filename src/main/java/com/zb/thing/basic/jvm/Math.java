package com.zb.thing.basic.jvm;

public class Math {
    public int compute() { //一个方法对应一块栈帧内存区域
        int a = 1;
        int b = 2;
        int c = (a + b) * 10;
        String astr = "a";
        String bstr = "b";
        String cstr = astr + bstr;
        StringBuilder stringBuilder = new StringBuilder("111");
        new Thread().start();
        return c;
    }

    public static void main(String[] args) {
        Math math = new Math();
        while (true) {
            math.compute();
        }
    }
}
