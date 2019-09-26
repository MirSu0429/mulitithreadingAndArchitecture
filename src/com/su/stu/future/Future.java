package com.su.stu.future;

/**
 * @Author: supengfei
 * @Date: 2019/8/24 21:27
 * @Description:
 */
public interface Future<T> {

    //返回计算结果，该方法会阻塞
    T get() throws InterruptedException;

    //判断任务是否执行完毕
    boolean done();
}
