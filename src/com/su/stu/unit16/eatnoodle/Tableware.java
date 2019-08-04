package com.su.stu.unit16.eatnoodle;

/**
 * @Author: supengfei
 * @Date: 2019/8/4 16:24
 * @Description:
 */
public class Tableware {
    private final String toolName;

    public Tableware(String toolName) {
        this.toolName = toolName;
    }

    @Override
    public String toString() {
        return "Tableware{" +
                "toolName='" + toolName + '\'' +
                '}';
    }
}
