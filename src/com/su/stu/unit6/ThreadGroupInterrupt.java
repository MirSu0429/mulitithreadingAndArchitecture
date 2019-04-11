package com.su.stu.unit6;

import javax.sound.midi.SoundbankResource;
import java.util.concurrent.TimeUnit;

/**
 * @author MirSu
 * @version V1.0
 * @Package com.su.stu.unit6
 * @Email 1023012015@qq.com
 * @date 2019/4/11 14:41
 * @Description:
 */
public class ThreadGroupInterrupt {
    public static void main(String[] args) throws InterruptedException {
        ThreadGroup threadGroup = new ThreadGroup("testGroup");

        new Thread(threadGroup, () -> {
            while (true) {
                try {
                    TimeUnit.MICROSECONDS.sleep(2);
                } catch (InterruptedException e) {
                    break;
                }
                System.out.println("ti 退出了");
            }
        },"t1").start();
        new Thread(threadGroup, () -> {
            while (true) {
                try {
                    TimeUnit.MICROSECONDS.sleep(2);
                } catch (InterruptedException e) {
                    break;
                }
                System.out.println("t2 退出了");
            }
        },"t2").start();

        TimeUnit.MILLISECONDS.sleep(2);

        threadGroup.interrupt();
    }
}
