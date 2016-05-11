package org.dean.learn.jvm;

import java.util.Map;

/**
 * 不错。书上写的是放到一个jsp页面里了
 * 代码清单 4-5 查看线程状况
 * Created by Dean on 2016/5/11.
 */
public class ThreadStackTrace {

    public static void main(String[] args) {
        boolean displayCurrentThread = true;
        for(Map.Entry<Thread, StackTraceElement[]> stackTrace : Thread.getAllStackTraces().entrySet()){
            Thread thread = stackTrace.getKey();
            StackTraceElement[] stack = stackTrace.getValue();
            if (!displayCurrentThread) {
                if (thread.equals(Thread.currentThread())) {
                    continue;
                }
            }
            System.out.println("\n线程：" + thread.getName() + "\n");
            for (StackTraceElement element : stack) {
                System.out.print("\t" + element + "\n");
            }
        }
    }

}
