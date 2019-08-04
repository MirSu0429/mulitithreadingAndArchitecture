package com.su.stu.unit16.eatnoodle;

import java.util.concurrent.TimeUnit;

/**
 * @Author: supengfei
 * @Date: 2019/8/4 16:35
 * @Description:
 */
public class EatNoodleThreadNew extends Thread {

    private final String name;
    private final TablewarePair tablewarePair;

    public EatNoodleThreadNew(String name, TablewarePair tablewarePair) {
        this.name = name;
        this.tablewarePair = tablewarePair;
    }

    @Override
    public void run() {

        while (true) {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            this.eat();
        }
    }

    private void eat() {
        synchronized (tablewarePair) {
            System.out.println(name + "拿起了" + tablewarePair.getDao());
                System.out.println(name + "拿起了" + tablewarePair.getCha());
                System.out.println(name + "正在池面条..........");
                System.out.println(name + "放下了" + tablewarePair.getCha());
            System.out.println(name + "放下了" + tablewarePair.getDao());
        }
    }
}
