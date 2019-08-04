package com.su.stu.unit15;

/**
 * @Author: supengfei
 * @Date: 2019/8/4 14:50
 * @Description:
 */
@FunctionalInterface
public interface Task<T> {
    T call() ;
}
