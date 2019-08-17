package com.su.stu.unit17;

import java.util.Arrays;

/**
 * @Author: supengfei
 * @Date: 2019/8/17 18:55
 * @Description:
 */
public class Test {
    private final static String TEXT = "abcdefjhijklmnopqrstuvwxyz";
    public static void main(String[] args) {
        final ShareData shareData = new ShareData(10);
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                for (int j = 0; j < TEXT.length(); j++) {
                    try {
                        String str = TEXT.charAt(j) + "";
                        System.out.println("开始写------------------" + str);
                        shareData.write(str);
                        System.out.println(Thread.currentThread() + "写入" + str);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (true) {
                    try {
                        System.out.println(Thread.currentThread() + "读取" + Arrays.toString(shareData.read()));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
