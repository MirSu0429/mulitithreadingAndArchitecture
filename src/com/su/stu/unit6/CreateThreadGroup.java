package com.su.stu.unit6;

/**
 * @author MirSu
 * @version V1.0
 * @Package com.su.stu.unit6
 * @Email 1023012015@qq.com
 * @date 2019/4/11 11:21
 * @Description: 线程组创建
 */
public class CreateThreadGroup {
    public static void main(String[] args) {
        //获取当前线程的 线程组
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        //定义一个新的线程组
        ThreadGroup newThreadGroup = new ThreadGroup("group1");
        System.out.println(newThreadGroup.getParent() == threadGroup);
        //定义新的线程组，其父线程是 newThreadGroup
        ThreadGroup newThreadGroup2 = new ThreadGroup(newThreadGroup, "group2");
        System.out.println(newThreadGroup2.getParent() == newThreadGroup);
    }
}
