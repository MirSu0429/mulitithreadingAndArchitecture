package com.su.stu.future;

/**
 * @Author: supengfei
 * @Date: 2019/8/24 21:32
 * @Description:
 */
@FunctionalInterface
public interface Task<IN, OUT> {
    //给定一个参数 经过计算返回结果
    OUT get(IN input);
}
