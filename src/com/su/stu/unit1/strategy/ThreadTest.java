package com.su.stu.unit1.strategy;

/**
 * @Author: supengfei
 * @Date: 2019/3/7 20:03
 * @Description:
 */
public class ThreadTest {
    private RunableTest runableTest;
    public ThreadTest() {
    }

    public ThreadTest(RunableTest runableTest) {
        this.runableTest = runableTest;
    }

    public final void start(){
        if (runableTest != null) {
            runableTest.run();
        }
    }
}
