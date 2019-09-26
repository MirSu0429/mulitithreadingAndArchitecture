package com.su.stu.future;

/**
 * @Author: supengfei
 * @Date: 2019/8/24 21:33
 * @Description:
 */
public class FutureTask<T> implements Future<T> {
    //计算结果
    private T result;
    //是否完成
    private boolean isDone = false;
//    定义对象锁
    private final Object LOCK = new Object();
    @Override
    public T get() throws InterruptedException {
        synchronized (LOCK) {
            //任务未完成时候 就等待
            while (!isDone) {
                LOCK.wait();
            }
            return result;
        }
    }

    //赋值结果
    protected void finish(T result) {
        synchronized (LOCK) {
            if (isDone) {
                return;
            }
            //指定结果
            this.result = result;
            this.isDone = true;
            LOCK.notifyAll();
        }
    }
    @Override
    public boolean done() {
        return isDone;
    }
}
