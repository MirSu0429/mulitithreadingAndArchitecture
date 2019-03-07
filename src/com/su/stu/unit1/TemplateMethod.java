package com.su.stu.unit1;

/**
 * @Author: supengfei
 * @Date: 2019/3/7 19:31
 * @Description:
 */
public class TemplateMethod {

    public final void start(String str){
        System.out.println("-----start-----");
        run(str);
        System.out.println("-----end-----");
    }
    public void run(String str){ }

    public static void main(String[] args) {
        new TemplateMethod(){
            @Override
            public void run(String str) {
                System.out.println(str);
            }
        }.start("hello world");

        new TemplateMethod(){
            @Override
            public void run(String str) {
                test(str);
            }
        }.start("你好!");
    }

    public static void test(String s) {
        System.out.println(s);
    }
}
