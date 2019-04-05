package com.su.stu.unit5.bolleanlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.IntStream;

import static java.lang.Thread.currentThread;
import static java.util.concurrent.ThreadLocalRandom.current;

/**
 * @Author: supengfei
 * @Date: 2019/4/5 15:46
 * @Description:
 */
public class Test {
    private final Lock lock = new BooleanLock();
    public void syncMethod(){
        try {
            lock.lock();
            int randomInt = current().nextInt(10);
            System.out.println(currentThread() + "获得了锁");
            TimeUnit.SECONDS.sleep(randomInt);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Test test = new Test();
     /*   IntStream.range(0, 10).mapToObj(i -> new Thread(test::syncMethod)).forEach(Thread::start);*/
        new Thread(test::syncMethod, "T1").start();
        TimeUnit.MILLISECONDS.sleep(2);

        Thread t2 = new Thread(test::sybcMethodTimeoutable, "T2");
        t2.start();
        TimeUnit.MILLISECONDS.sleep(10);

    }

    public void sybcMethodTimeoutable() {
        try {
            lock.lock(1000);
            System.out.println(currentThread() + "获得了锁");
            int randomInt = current().nextInt(10);
            TimeUnit.SECONDS.sleep(randomInt);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
