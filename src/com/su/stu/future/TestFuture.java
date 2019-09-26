package com.su.stu.future;

import java.util.concurrent.TimeUnit;

/**
 * @Author: supengfei
 * @Date: 2019/9/26 21:46
 * @Description:
 */
public class TestFuture {
    public static void main(String[] args) throws InterruptedException {
        TestFuture testFuture = new TestFuture();
//        testFuture.testVoid();
        testFuture.testCallBack();
//        testFuture.testResult();
    }
    public void testVoid() throws InterruptedException {
        FutureService<Void, Void> service = FutureService.getInstance();
        Future future = service.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("执行完毕");

        });
        future.get();
    }

    private void testResult() throws InterruptedException {
        FutureService<String, Integer> futureService = FutureService.getInstance();
        Future<Integer> future = futureService.submit(in -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return in.length();
        }, "你好");
        System.out.println(future.get());
    }

    public void testCallBack() {
        FutureService<String, Integer> futureService = FutureService.getInstance();
        futureService.submit(input -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return input.length();
        },"aaaaads",System.out::println);
    }
}
