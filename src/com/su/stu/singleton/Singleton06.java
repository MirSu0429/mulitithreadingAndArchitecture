package com.su.stu.singleton;

/**
 * @Author: supengfei
 * @Date: 2019/7/27 22:03
 * @Description:
 */
public final class Singleton06 {
    private Singleton06(){}
    private static class Holder{
        private static Singleton06 instance = new Singleton06();
    }

    public static Singleton06 getInstance() {
        return Holder.instance;
    }
}
