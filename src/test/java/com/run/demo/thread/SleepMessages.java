package com.run.demo.thread;

/**
 * @author : hewei
 * @date : 2018/1/1
 */
public class SleepMessages {
    public static void main(String[] args) {

            String importantInfo[] = {
                    "Mares eat oats",
                    "Does eat oats",
                    "Little lambs eat ivy",
                    "a kid will eat ivy too"
            };
            for (int i = 0; i < importantInfo.length; i++) {
                try {
                    Thread.sleep(4000);
                } catch(InterruptedException e) {
                    e.printStackTrace();
                    return;
                }
                System.out.println(importantInfo[i]);
            }

    }
}
