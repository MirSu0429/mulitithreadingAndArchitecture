package com.su.stu.unit16.eatnoodle;

/**
 * @Author: supengfei
 * @Date: 2019/8/4 16:36
 * @Description:
 */
public class TablewarePair {
    private final Tableware dao;
    private final Tableware cha;

    public Tableware getDao() {
        return dao;
    }

    public Tableware getCha() {
        return cha;
    }

    public TablewarePair(Tableware dao, Tableware cha) {
        this.dao = dao;
        this.cha = cha;
    }
}
