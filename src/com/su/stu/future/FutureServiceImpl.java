package com.su.stu.future;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: supengfei
 * @Date: 2019/8/24 21:29
 * @Description: 提交任务时候 创建一个新的线程 来受理该任务
 */
public class FutureServiceImpl<IN,OUT> implements FutureService<IN, OUT> {

    //为执行任务的线程声明一个名字
    private final static String FUTURE_THREAD_PREFIX = "FUTURE-";

    private final static AtomicInteger nextCounter = new AtomicInteger(0);

    private String getNextName(){
        return FUTURE_THREAD_PREFIX + nextCounter.getAndIncrement();
    }

    @Override
    public Future<?> submit(Runnable runnable) {
        final FutureTask<Void> futureTask = new FutureTask<>();
        new Thread(() -> {
            runnable.run();
            //结束后 返回null
            futureTask.finish(null);
        }, getNextName()).start();
        return futureTask;
    }

    @Override
    public Future<OUT> submit(Task<IN, OUT> task, IN input) {
        final FutureTask<OUT> futureTask = new FutureTask<>();
        new Thread(() -> {
            OUT result = task.get(input);
            futureTask.finish(result);
        }, getNextName()).start();
        return futureTask;
    }

    @Override
    public Future<OUT> submit(Task<IN, OUT> task, IN input, CallBack<OUT> callBack) {
        final FutureTask<OUT> futureTask = new FutureTask<>();
        new Thread(() -> {
            OUT result = task.get(input);
            futureTask.finish(result);
            if (null != callBack) {
                callBack.call(result);
            }
        }, getNextName()).start();
        return futureTask;
    }
}
