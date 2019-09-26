package com.su.stu.singleton;

/**
 * @Author: supengfei
 * @Date: 2019/7/27 21:53
 * @Description:
 */
public final class Singleton04 {
    private static Singleton04 instance = null;

//    Connection connection;
//
//    Socket socket;
    private Singleton04(){
//        this.connection  ;
//        this.socket;
    }

    public static Singleton04 getInstance() {
        if (null == instance) {
            synchronized (Singleton04.class) {
                if (null == instance) {
                    instance = new Singleton04();
                }
            }
        }
        return instance;
    }

}
