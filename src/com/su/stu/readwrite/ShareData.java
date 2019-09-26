package com.su.stu.readwrite;

import com.su.stu.readwrite.base.Lock;
import com.su.stu.readwrite.base.ReadWriteLock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author: supengfei
 * @Date: 2019/8/17 18:41
 * @Description:
 */
public class ShareData {
    private final List<String> shareList = new ArrayList<>();

    private final ReadWriteLock readWriteLock = ReadWriteLock.readWriteLock();

    private final Lock readLock = readWriteLock.readLock();

    private final Lock writeLock = readWriteLock.writeLock();

    private final int length;

    public ShareData(int length) {
        this.length = length;
        for (int i = 0; i < length; i++) {
            shareList.add("" + i);
        }
    }

    public String[] read() throws InterruptedException {
        try{
            readLock.lock();
            String[] newStr = new String[shareList.size()];
            for (int i = 0; i < shareList.size(); i++) {
                newStr[i] = shareList.get(i);
            }
            TimeUnit.SECONDS.sleep(1);
            return newStr;
        }finally {
            readLock.unlock();
        }
    }

    public void write(String string) throws InterruptedException {

       try {
           writeLock.lock();
           this.shareList.add(string);
           TimeUnit.SECONDS.sleep(1);
       }finally {
           writeLock.unlock();
       }
    }
}
