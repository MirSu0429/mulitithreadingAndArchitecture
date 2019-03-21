package com.su.stu.unit2;

/**
 * @Author: supengfei
 * @Date: 2019/3/7 20:26
 * @Description:
 */
public class ThreadGroupTest {
    public static void main(String[] args) {

        Thread t1 = new Thread("t1");

        ThreadGroup threadGroup = new ThreadGroup("testGroup");

        Thread t2 = new Thread(threadGroup,"t2");

        ThreadGroup mainThreadGroup = Thread.currentThread().getThreadGroup();
        System.out.println("main 线程的线程组"+mainThreadGroup);
        System.out.println("main 线程与 t1 的线程组:"+ (mainThreadGroup == t1.getThreadGroup()));
        System.out.println("t1 与 t2 的线程组:"+(t1.getThreadGroup() == t2.getThreadGroup()) );
        System.out.println("main 与 t2 的线程组:"+(mainThreadGroup == t2.getThreadGroup()) );
        System.out.println("threadGroup 与 t2 的线程组:"+(threadGroup == t2.getThreadGroup()) );

    }
}
