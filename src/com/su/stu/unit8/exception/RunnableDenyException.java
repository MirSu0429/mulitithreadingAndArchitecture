package com.su.stu.unit8.exception;

/**
 * @Author: supengfei
 * @Date: 2019/7/21 16:37
 * @Description:
 */
public class RunnableDenyException extends RuntimeException {
    public RunnableDenyException(String msg) {
        super(msg);
    }
}
