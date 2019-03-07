package com.su.stu.unit1.strategy;

/**
 * @Author: supengfei
 * @Date: 2019/3/7 19:55
 * @Description:
 */
public class Strategy implements RunableTest{
        @Override
        public void run() {
            System.out.println("你好!");
        }

    public static void main(String[] args) {
        new ThreadTest(new Strategy()).start();
    }

}
