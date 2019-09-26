package com.su.stu.singleton;

/**
 * @Author: supengfei
 * @Date: 2019/7/27 22:10
 * @Description:
 */
public class Singleton08 {
    private Singleton08(){}

    private enum EnumHolder{
        INSTANCE;
        private Singleton08 instance;
        EnumHolder(){
            this.instance = new Singleton08();
        }
        private Singleton08 getSingleton(){
            return instance;
        }

    }

    private static Singleton08 getInstance() {
        return EnumHolder.INSTANCE.getSingleton();
    }
}
