package org.dean.learn.jvm;

/**
 * VM Args : -verbose:gc -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728
 * 代码清单 3-6 大对象直接进入老年代
 * Created by Dean on 2016/5/10.
 */
public class BigObjPretenure {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        testPretenureSizeThreshold();
    }

    private static void testPretenureSizeThreshold() {
        byte[] allocation;
        allocation = new byte[4 * _1MB];//直接分配在老年代中
    }

}
