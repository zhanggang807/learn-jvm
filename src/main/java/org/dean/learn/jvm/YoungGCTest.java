package org.dean.learn.jvm;

/**
 * VM参数 ：-verbose:gc -Xms20M -XMx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * 代码清单 3-5 新生代 Minor GC
 * Created by Dean on 2016/5/9.
 */
public class YoungGCTest {

    private static final int _1MB = 1024 * 1024;

    public static void testAllocation(){
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];//出现一次 Minor GC
    }
}
