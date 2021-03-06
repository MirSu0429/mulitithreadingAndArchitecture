package com.su.stu.observable;

/**
 * @Author: supengfei
 * @Date: 2019/8/4 14:44
 * @Description:
 */
public interface Observable {

    enum Cycle{
        STARTED,RUNNING,DONE,ERROR,
        ;
    }

    Cycle getCycle();

    void start();

    void interrupt();
}
