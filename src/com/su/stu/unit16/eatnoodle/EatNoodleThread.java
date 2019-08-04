package com.su.stu.unit16.eatnoodle;

/**
 * @Author: supengfei
 * @Date: 2019/8/4 16:25
 * @Description:
 */
public class EatNoodleThread extends Thread {
    private final String name;
    private final Tableware dao;
    private final Tableware cha;

    public EatNoodleThread(String name, Tableware dao, Tableware cha) {
        this.name = name;
        this.dao = dao;
        this.cha = cha;
    }

    private void eat() {
        synchronized (dao) {
            System.out.println(name + "拿起了" + dao);
            synchronized (cha) {
                System.out.println(name + "拿起了" + cha);
                System.out.println(name + "正在池面条");
                System.out.println(name + "放下了" + cha);
            }
            System.out.println(name + "放下了" + dao);
        }
    }

    @Override
    public void run() {
        while (true) {
            this.eat();
        }
    }
}
