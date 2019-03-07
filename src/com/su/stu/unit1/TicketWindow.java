package com.su.stu.unit1;

/**
 * @Author: supengfei
 * @Date: 2019/3/7 19:43
 * @Description:
 */
public class TicketWindow extends Thread {
    private  String name ;

    private static final int MAX = 500;

    private static int index = 1;

    @Override
    public void run() {
        while (index < MAX) {
            System.out.println(name + "当前号码是:" + (index++));
        }
    }

    public TicketWindow(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        new TicketWindow("1号机").start();
        new TicketWindow("2号机").start();
        new TicketWindow("3号机").start();
        new TicketWindow("4号机").start();
    }
}
