package com.su.stu.unit12;

import javax.sound.midi.SoundbankResource;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Author: supengfei
 * @Date: 2019/7/24 21:48
 * @Description:
 */
public class VolattileFoo {
    final static int MAX = 5;
    static  int initValue = 0;

    public static void main(String[] args) {
        new Thread(() -> {
            int localValue = initValue;
            while (localValue < MAX) {
                if (initValue != localValue) {
                    System.out.println("initValue的值将要gengx了" + initValue);
                    localValue = initValue;
                }
            }
        }).start();

        new Thread(()->{
            int localValue = initValue;
            while (localValue < MAX) {
                System.out.println("initValue的值将要改变了" + (++localValue));
                initValue = localValue;
                /*try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/

            }
        }).start();
    }
}
