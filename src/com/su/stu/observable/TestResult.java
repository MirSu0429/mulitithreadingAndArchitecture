package com.su.stu.observable;

import java.util.concurrent.*;

/**
 * @Author: supengfei
 * @Date: 2019/8/4 15:14
 * @Description:
 */
public class TestResult {
//    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 3, 10, TimeUnit.SECONDS, new LinkedBlockingDeque());
    public static void main(String[] args) {
        final TaskLifecycle<String> lifecycle = new TaskLifecycle.EmptyLifecycle<String>() {
            @Override
            public void onFinish(Thread thread, String result) {
                System.out.println("返回值是:" + result);
            }
        };
        Observable observable = new ObservableThread<>(lifecycle,()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("结束");
            return "jieshu";
        });
        observable.start();
    }

}
