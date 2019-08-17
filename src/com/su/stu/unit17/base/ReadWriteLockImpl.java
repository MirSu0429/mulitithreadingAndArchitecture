package com.su.stu.unit17.base;

/**
 * @Author: supengfei
 * @Date: 2019/8/17 17:49
 * @Description:
 */
public class ReadWriteLockImpl implements ReadWriteLock {
    //定义对象锁
    private final Object MUTRX = new Object();
    //当前多少线程在写
    private int writintWriters = 0;
    //当前多谢现场的在等待写入
    private int waitintWriters = 0;
    //当前多少线程正在read
    private int readingReaders = 0;
    //read和write的偏好设置
    private boolean preferWriter;

    public ReadWriteLockImpl(boolean preferWriter) {
        this.preferWriter = preferWriter;
    }

    public ReadWriteLockImpl() {
        this(true);
    }

    @Override
    public Lock readLock() {
        return new ReadLock(this);
    }

    @Override
    public Lock writeLock() {
        return new WriteLock(this);
    }

    //使写的线程数增加
    void incrementWritingWriters() {
        this.writintWriters++;
    }

    //使等待写的线程数增加
    void incrementWaitingWriters() {
        this.waitintWriters++;
    }

    //使读线程的数增加
    void incrementReadingReaders() {
        this.readingReaders++;
    }

    //使写的线程数减少
    void decrementWritingWriters() {
        this.writintWriters--;
    }

    //使等待写的线程数减少
    void decrementWaitingWriters() {
        this.waitintWriters--;
    }

    //使读线程的数减少
    void decrementReadingReaders() {
        this.readingReaders--;
    }

    @Override
    public int getWritingWriters() {
        return this.writintWriters;
    }

    @Override
    public int getWaitingWriters() {
        return this.waitintWriters;
    }

    @Override
    public int getReadingReaders() {
        return this.readingReaders;
    }

    Object getMUTRX() {
        return this.MUTRX;
    }

    public boolean getPreferWriter() {
        return this.preferWriter;
    }

    public void setPreferWriter(boolean preferWriter) {
        this.preferWriter = preferWriter;
    }
}
