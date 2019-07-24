package com.su.stu.unit8;

import com.su.stu.unit8.exception.RunnableDenyException;

/**
 * @Author: supengfei
 * @Date: 2019/7/21 16:30
 * @Description:
 */
public interface DenyPolicy {
    void reject(Runnable runnable, ThreadPool threadPool);

    //该策略直接将任务丢弃
    class DiscardDenyPolicy implements DenyPolicy {
        @Override
        public void reject(Runnable runnable, ThreadPool threadPool) {

        }
    }
    //该策略抛出异常
    class AbortDenyPolicy implements DenyPolicy {
        @Override
        public void reject(Runnable runnable, ThreadPool threadPool) {
            throw new RunnableDenyException("the runnable " + runnable + " will be abort");
        }
    }
    //该策略使任务在提交者所在线程中执行
    class RunnerDenyPolicy implements DenyPolicy {
        @Override
        public void reject(Runnable runnable, ThreadPool threadPool) {
            if (!threadPool.isShutdown()) {
                runnable.run();
            }
        }
    }

}
