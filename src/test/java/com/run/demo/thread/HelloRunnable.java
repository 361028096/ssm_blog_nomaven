package com.run.demo.thread;

/**
 * @author : hewei
 * @date : 2018/1/1
 */
public class HelloRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("Hello from a runnable");
    }

    public static void main(String[] args) {
        (new Thread(new HelloRunnable())).start();
    }
}
