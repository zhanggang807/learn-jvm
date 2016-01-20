package org.dean.learn.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Arags: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * 代码清单 2-3 堆内存溢出异常测试
 * Created by Dean on 2016/1/1.
 */
public class HeapOOM {

    static class OOMObject{
    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();
        while (true){
            list.add(new OOMObject());
        }
        //运行即会报内存溢出异常
    }

}