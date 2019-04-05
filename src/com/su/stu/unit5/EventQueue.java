package com.su.stu.unit5;

import java.util.LinkedList;

/**
 * @Author: supengfei
 * @Date: 2019/4/3 20:28
 * @Description:
 */
public class EventQueue {
    private final  int max ;
    static class Event {}

    private final static LinkedList<Event> eventQueue = new LinkedList<>();

    private final static int MAX_EVENT = 10;
    public EventQueue(){
        this(MAX_EVENT);
    }
    public EventQueue(int max){
        this.max = max;
    }

    public void offer(Event event) {
        synchronized (eventQueue) {
            while (eventQueue.size() >= max) {
                try {
                    console("队列已经满了");
                    eventQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            console("进如列队成功");
            eventQueue.add(event);
            console("长度" + eventQueue.size());
            eventQueue.notifyAll();
        }
    }

    public Event take(){
        synchronized (eventQueue) {
            while (eventQueue.isEmpty()) {
                try {
                    console("队列已空");
                    eventQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Event event = eventQueue.removeFirst();
            this.eventQueue.notifyAll();
            console("事件"+event +"已经使用");
            return event;
        }
    }

    private void console(String message){
        System.out.printf("%s:%s\n",Thread.currentThread().getName(),message);
    }


}
