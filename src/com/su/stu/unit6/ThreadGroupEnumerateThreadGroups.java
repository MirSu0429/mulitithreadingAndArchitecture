package com.su.stu.unit6;

import java.util.concurrent.TimeUnit;

/**
 * @author MirSu
 * @version V1.0
 * @Package com.su.stu.unit6
 * @Email 1023012015@qq.com
 * @date 2019/4/11 14:24
 * @Description:
 */
public class ThreadGroupEnumerateThreadGroups {
    public static void main(String[] args) throws InterruptedException {
        ThreadGroup threadGroup1 = new ThreadGroup("threadGroup1");
        ThreadGroup threadGroup2 = new ThreadGroup(threadGroup1,"threadGroup2");

        TimeUnit.SECONDS.sleep(1);
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
        ThreadGroup[] list = new ThreadGroup[mainGroup.activeGroupCount()];

        System.out.println(mainGroup.enumerate(list));
        System.out.println(mainGroup.enumerate(list, false));

    }
}
