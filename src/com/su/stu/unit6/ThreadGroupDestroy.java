package com.su.stu.unit6;

/**
 * @author MirSu
 * @version V1.0
 * @Package com.su.stu.unit6
 * @Email 1023012015@qq.com
 * @date 2019/4/11 14:47
 * @Description:
 */
public class ThreadGroupDestroy {
    public static void main(String[] args) {
        ThreadGroup threadGroup = new ThreadGroup("testGroup");

        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();

        System.out.println("threadGroup.isDestroyed = " + threadGroup.isDestroyed());

        mainGroup.list();

        threadGroup.destroy();

        System.out.println("threadGroup.isDestroyed = " + threadGroup.isDestroyed());
        mainGroup.list();

    }
}
