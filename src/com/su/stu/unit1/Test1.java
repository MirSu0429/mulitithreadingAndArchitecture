package com.su.stu.unit1;

import java.util.concurrent.TimeUnit;

/**
 * @Author: supengfei
 * @Date: 2019/3/7 19:00
 * @Description:
 */
public class Test1 {
    public static void main(String[] args) {
        /*new Thread(){
            @Override
            public void run() {
                seeNew();
            }
        }.start();*/
    //lambda 表达式
        new Thread(Test1::seeNew).start();
        enjoyMusic();
    }
    private static void  seeNew()  {
        for (; ; ) {
            System.out.println("看新闻!");
            sleep(1);
        }
    }
    private static void  enjoyMusic() {
        for (; ; ) {
            System.out.println("听音乐!");
            sleep(1);
        }
    }

    private static void sleep(int s){
        try {
            TimeUnit.SECONDS.sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
