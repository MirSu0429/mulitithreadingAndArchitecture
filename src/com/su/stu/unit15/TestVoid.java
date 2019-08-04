package com.su.stu.unit15;

import java.util.concurrent.TimeUnit;

/**
 * @Author: supengfei
 * @Date: 2019/8/4 15:10
 * @Description:
 */
public class TestVoid {

    public static void main(String[] args) {
        Observable observable = new ObservableThread<>(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("运行结束");
            return null;
        });
        observable.start();
    }
}
