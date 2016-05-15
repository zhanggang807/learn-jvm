package org.dean.learn.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 代码清单 4-8 JConsole监视代码
 * Created by Dean on 2016/5/12.
 */
public class TestJConsole {

    static class OOMObject {
        public byte[] placeholder = new byte[64 * 1024];
    }

    public static void fillHeap(int num) throws Exception {
        List<OOMObject> list = new ArrayList<OOMObject>();
        for (int i = 0; i < num; i++) {
            //稍作延时，令监控曲线的变化更加明显
            Thread.sleep(500);
            list.add(new OOMObject());
        }
        System.gc();
    }

    public static void main(String[] args) throws Exception {
        fillHeap(10000);
    }

}
