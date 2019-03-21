package com.su.stu.unit3.jointest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * @Author: supengfei
 * @Date: 2019/3/21 21:11
 * @Description:
 */
public class FightQueryTest {
    private static List<String> fightCompany = Arrays.asList("深圳航空", "中国航空", "河南航空");

    public static void main(String[] args) {
        List<String> results = search("郑州", "无锡");
        System.out.println("---------查询结果-------");
        results.forEach(System.out::println);
    }

    private static List<String> search(String origin,String destination){
        List<String> result = new ArrayList<>();
        //创建查询航班的线程
       List<FinghtQueryTask> tasks =  fightCompany.stream().map(e -> creat(e, origin, destination)).collect(toList());

        tasks.forEach(Thread::start);
        //调用线程的join方法,阻塞当前线程
        tasks.forEach(t->{
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        //获取每个线程的结果,并加入result中

        tasks.stream().map(FinghtQuery::get).forEach(result::addAll);
       /* for (FinghtQueryTask task : tasks) {
            result.addAll(task.get());
        }*/
        return result;
    }

    private static FinghtQueryTask creat(String fight,String origin,String destination){
        return new FinghtQueryTask(fight, origin, destination);
    }
}
