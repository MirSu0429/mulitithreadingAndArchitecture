package com.su.stu.future;

/**
 * @Author: supengfei
 * @Date: 2019/8/24 21:29
 * @Description:
 */
public interface FutureService<IN,OUT> {
    //提交不需要返回值的任务
    Future<?> submit(Runnable runnable);
    //提交需要返回值的任务
    Future<OUT> submit(Task<IN,OUT> task,IN input);

    //提交需要返回值的任务
    Future<OUT> submit(Task<IN,OUT> task,IN input,CallBack<OUT> callBack);

    //创建futureService的实现
    static <T, R> FutureService<T, R> getInstance() {
        return new FutureServiceImpl<>();
    }
}
