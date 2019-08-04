package com.su.stu.unit15;

/**
 * @Author: supengfei
 * @Date: 2019/8/4 14:47
 * @Description:
 */
public interface TaskLifecycle<T> {
    void onStart(Thread thread);
    void onRunning(Thread thread);
    void onFinish(Thread thread ,T result);
    void onError(Thread thread,Exception e);

    class EmptyLifecycle<T> implements TaskLifecycle<T> {
        @Override
        public void onStart(Thread thread) {

        }

        @Override
        public void onRunning(Thread thread) {

        }

        @Override
        public void onFinish(Thread thread, T result) {

        }

        @Override
        public void onError(Thread thread, Exception e) {

        }
    }

}
