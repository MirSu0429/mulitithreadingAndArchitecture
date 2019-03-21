package com.su.stu.unit3.jointest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * @Author: supengfei
 * @Date: 2019/3/21 20:56
 * @Description:
 */
public class FinghtQueryTask extends Thread implements FinghtQuery {
    private  String origin;
    private  String destination;
    private List<String> fightList = new ArrayList<>();

    public FinghtQueryTask(String airline,String origin, String destination) {
        super("{"+ airline+"}");
        this.origin = origin;
        this.destination = destination;
    }

    @Override
    public void run() {
        System.out.println("查询"+ this.getName()+origin+"飞往"+destination);
        int i = ThreadLocalRandom.current().nextInt(10);
        try {
            TimeUnit.SECONDS.sleep(i);
            this.fightList.add("正在查询----" + getName() + i);
            System.out.println("查询成功:" + getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> get() {
        return this.fightList;
    }
}
