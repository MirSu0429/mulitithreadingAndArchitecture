package com.su.stu.finalobject;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @Author: supengfei
 * @Date: 2019/8/24 20:55
 * @Description:
 */
public final class FinalIntergerAcc {
    private final int init;

    public FinalIntergerAcc(int init) {
        this.init = init;
    }

    public FinalIntergerAcc(FinalIntergerAcc finalIntergerAcc, int init) {
        this.init = finalIntergerAcc.getValue() + init;
    }

    public FinalIntergerAcc add(int i) {
        return new FinalIntergerAcc(this, i);
    }

    public int getValue() {
        return this.init;
    }

    public static void main(String[] args) {
        FinalIntergerAcc finalIntergerAcc = new FinalIntergerAcc(0);
        IntStream.range(0, 3).forEach(i->new Thread(()->{
            int inc = 0;
            while (true) {
                int oldValue = finalIntergerAcc.getValue();
                int result = finalIntergerAcc.add(inc).getValue();
                System.out.println(oldValue + "+" + inc + "=" + result);
                if (inc+oldValue!=result) {
                    System.out.println("错误-----------------" + oldValue + "+" + inc + "=" + result);
                }
                inc++;
                slowly();
            }
        }).start());
    }

    private static void slowly() {
        try {
            TimeUnit.MILLISECONDS.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
