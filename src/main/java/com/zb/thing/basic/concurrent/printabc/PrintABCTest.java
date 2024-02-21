package com.zb.thing.basic.concurrent.printabc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PrintABCTest {
    private static final ReentrantLock reentrantLock = new ReentrantLock();

    private static final Condition acondition = reentrantLock.newCondition();
    private static final Condition bcondition = reentrantLock.newCondition();
    private static final Condition ccondition = reentrantLock.newCondition();
    private static int count = 0;
    public static void main(String[] args) throws InterruptedException {

//        List<User> users1 = Arrays.asList(new User(1, "1"), new User(2, "2"), new User(0, "0"));
//
//        for (User user : users1) {
//            System.out.println(user.getId());
//        }
//        System.out.println("----");
//        for (User user : users1.stream().sorted(Comparator.comparing(User::getId)).collect(Collectors.toList())) {
//            System.out.println(user.getId());
//        }
        new Thread(new PrintA()).start();
        new Thread(new PrintB()).start();
        new Thread(new PrintC()).start();

    }


    static class PrintA implements Runnable {
        @Override
        public void run() {
            while (true) {
                reentrantLock.lock();
                try {
                    while (count % 3 != 0) {
                        acondition.await();
                    }
                    if (count >= 30) {
                        System.out.println("a out");
                        bcondition.signal();
                        count++;
                        break;
                    }
                    System.out.print("A");
                    count++;
                    bcondition.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    reentrantLock.unlock();
                }
            }
        }
    }
    static class PrintB implements Runnable {
        @Override
        public void run() {
            while (true) {
                reentrantLock.lock();
                try {
                    while (count % 3 != 1) {
                        bcondition.await();
                    }
                    if (count >= 30) {
                        System.out.println("b out");
                        ccondition.signal();
                        count++;
                        break;
                    }
                    System.out.print("B");
                    count++;
                    ccondition.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    reentrantLock.unlock();
                }
            }
        }
    }
    static class PrintC implements Runnable {
        @Override
        public void run() {
            while (true) {
                reentrantLock.lock();
                try {
                    while (count % 3 != 2) {
                        ccondition.await();
                    }
                    if (count >= 30) {
                        System.out.println("c out");
                        break;
                    }
                    System.out.println("C");
                    count++;
                    acondition.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    reentrantLock.unlock();
                }
            }
        }
    }
}
