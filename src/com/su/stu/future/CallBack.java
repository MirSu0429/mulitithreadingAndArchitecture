package com.su.stu.future;

/**
 * @Author: supengfei
 * @Date: 2019/9/26 21:59
 * @Description:
 */
@FunctionalInterface
public interface CallBack<T> {
    void call( T t);
}
