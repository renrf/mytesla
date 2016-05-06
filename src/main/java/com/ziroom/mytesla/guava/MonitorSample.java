package com.ziroom.mytesla.guava;

import com.google.common.util.concurrent.Monitor;

import java.util.LinkedList;
import java.util.List;

/**
 * @author liumy  .
 * @time 2016/5/6　16:34
 * @email　 liumy46@ziroom.com
 */
public class MonitorSample {

    private final Monitor monitor = new Monitor();

    final Object[] items = new Object[100];
    int putptr/*写索引*/, takeptr/*读索引*/, count=100/*队列中存在的数据个数*/;

    private final Monitor.Guard valuePresent = new Monitor.Guard(monitor) {
        public boolean isSatisfied() {
            return items != null;
        }
    };
    private final Monitor.Guard valueAbsent = new Monitor.Guard(monitor) {
        public boolean isSatisfied() {
            return items == null&&items.length>count;
        }
    };
    public Object get() throws InterruptedException {
        monitor.enterWhen(valuePresent);
        try {
            Object x = items[takeptr];//取值
            if (++takeptr == items.length) takeptr = 0;//如果读索引读到队列的最后一个位置了，那么置为0
            --count;//个数--
            return x;
        } finally {
            monitor.leave();
        }
    }
    public void set(Object newValue) throws InterruptedException {
        monitor.enterWhen(valueAbsent);
        try {
            items[putptr] = newValue;//赋值
            if (++putptr == items.length) putptr = 0;//如果写索引写到队列的最后一个位置了，那么置为0
            ++count;//个数++
        } finally {
            monitor.leave();
        }
    }
}
