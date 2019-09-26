package com.su.stu.finalobject;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @Author: supengfei
 * @Date: 2019/8/24 20:39
 * @Description:  同步方法解决 并发
 */
public class IntegetAccumulater {
//    public static void main(String[] args) {
//        List<String> list = Arrays.asList("java", "js", "html", "css");
//        list.parallelStream().map(String::toUpperCase).forEach(System.out::println);
//        list.forEach(System.out::println);
//    }

    private int init;

    public IntegetAccumulater(int init) {
        this.init = init;
    }

    public int add(int i) {
        this.init += i;
        return this.init;
    }

    public int getValue() {
        return this.init;
    }

    public static void main(String[] args) {
        IntegetAccumulater accumulater = new IntegetAccumulater(0);

        IntStream.range(0,3).forEach(i->new Thread(()->{
            int inc = 0;
            while (true) {
//                int oldValue = accumulater.getValue();
//                int result = accumulater.add(inc);
                int oldValue;
                int result;
                synchronized (accumulater) {
                    oldValue = accumulater.getValue();
                    result = accumulater.add(inc);
                }
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
