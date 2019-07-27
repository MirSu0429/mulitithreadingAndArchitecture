package com.su.stu.unit14;

/**
 * @Author: supengfei
 * @Date: 2019/7/27 21:53
 * @Description:
 */
public final class Singleton05 {
    private volatile static Singleton05 instance = null;

//    Connection connection;
//
//    Socket socket;
    private Singleton05(){
//        this.connection  ;
//        this.socket;
    }

    public static Singleton05 getInstance() {
        if (null == instance) {
            synchronized (Singleton05.class) {
                if (null == instance) {
                    instance = new Singleton05();
                }
            }
        }
        return instance;
    }

}
