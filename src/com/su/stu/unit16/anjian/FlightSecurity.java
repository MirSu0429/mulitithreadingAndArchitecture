package com.su.stu.unit16.anjian;

/**
 * @Author: supengfei
 * @Date: 2019/8/4 16:11
 * @Description:
 */
public class FlightSecurity {
    private int count = 0;

    private String 登机牌 = "null";

    private String 身份证 = "null";

    private void check() {
        if (登机牌.charAt(0) != 身份证.charAt(0)) {
            throw new RuntimeException("出错信息为:--->" + toString());
        }
    }

    @Override
    public String toString() {
        return "FlightSecurity{" +
                "count=" + count +
                ", 登机牌='" + 登机牌 + '\'' +
                ", 身份证='" + 身份证 + '\'' +
                '}';
    }

    public synchronized void  pass(String 登机牌,String 身份证) {
        this.身份证 = 身份证;
        this.登机牌 = 登机牌;
        this.count++;
        check();
    }
}
