package com.su.stu.unit16.eatnoodle;

/**
 * @Author: supengfei
 * @Date: 2019/8/4 16:29
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        Tableware dao = new Tableware("dao");
        Tableware cha = new Tableware("cha");
       /* new EatNoodleThread("A", dao, cha).start();
        new EatNoodleThread("B", cha, dao).start();*/
        /*↑↑↑↑↑↑↑↑↑↑以上引起死锁↑↑↑↑↑↑↑↑↑↑↑*/

        TablewarePair tablewarePair = new TablewarePair(dao, cha);
        new EatNoodleThreadNew("A", tablewarePair).start();
        new EatNoodleThreadNew("B", tablewarePair).start();
    }
}
