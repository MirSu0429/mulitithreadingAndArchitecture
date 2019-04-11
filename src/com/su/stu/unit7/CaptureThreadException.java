package com.su.stu.unit7;

import java.util.concurrent.TimeUnit;

/**
 * @author MirSu
 * @version V1.0
 * @Package com.su.stu.unit7
 * @Email 1023012015@qq.com
 * @date 2019/4/11 15:01
 * @Description:
 */
public class CaptureThreadException {
    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler((t,e)->{
            System.out.println(t.getName() + "线程名称");
            e.printStackTrace();
        });

        final Thread thread = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
            }
            System.out.println(1 / 0);
        }, "testThread");
        thread.start();

    }
}
