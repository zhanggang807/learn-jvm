package org.dean.learn.jvm;

/**
 * VM Args : -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15 -XX:+PrintTenuringDistribution
 * 代码清单 3-8 长期存活的对象进入老年代
 * Created by Dean on 2016/5/10.
 */
public class YoungObjTenuring2 {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        testTenuringThreshold2();
    }

    private static void testTenuringThreshold2() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[_1MB / 4];
        //allocation1 + allocation2 大于 survivor空间一半
        allocation2 = new byte[_1MB / 4];
        allocation3 = new byte[4 * _1MB];
        allocation4 = new byte[4 * _1MB];
        allocation4 = null;
        allocation4 = new byte[4 * _1MB];
    }

    //满足动态对象年龄判定，同年龄对象大小大于Survivor空间大小的一半，未达到晋升年龄也可以直接晋升到老年代中

}
