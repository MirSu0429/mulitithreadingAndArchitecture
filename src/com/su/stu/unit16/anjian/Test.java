package com.su.stu.unit16.anjian;

/**
 * @Author: supengfei
 * @Date: 2019/8/4 16:16
 * @Description:
 */
public class Test {
    static class Passengers extends Thread {
        private final FlightSecurity flightSecurity;
        private final String 登机牌;

        private final String 身份证;

        public Passengers(FlightSecurity flightSecurity, String 登机牌, String 身份证) {
            this.flightSecurity = flightSecurity;
            this.登机牌 = 登机牌;
            this.身份证 = 身份证;
        }

        @Override
        public void run() {
            while (true) {
                flightSecurity.pass(登机牌, 身份证);
            }
        }

    }

    public static void main(String[] args) {
        final FlightSecurity flightSecurity = new FlightSecurity();
        new Passengers(flightSecurity, "A0", "AA0").start();
        new Passengers(flightSecurity, "B0", "BB0").start();
        new Passengers(flightSecurity, "C0", "CC0").start();
    }
}
