package org.dean.learn.jvm;

/**
 * testGC()方法执行后，pbjA和objB会不会被GC呢？
 * 这是一个测试引用计数算法的小程序
 * 代码清单 3-1 引用计数算法的缺陷
 * Created by Dean on 2016/1/17.
 */
public class ReferenceCountingGC {

    public Object instance = null;
    private static final int _1MB = 1024 * 1024;

    /**
     * 这个成员属性的唯一意义就是占用内存，以便能在GC日志中看清楚是否被回收过。
     */
    private byte[] bigSize = new byte[2 * _1MB];

    public static void testGC(){
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        objA.instance = objB;
        objB.instance = objA;
        objA = null;
        objB = null;

        //假设在这行发生GC，objA和objB是否能被回收呢？
        System.gc();

    }
    /**
     * 运行结果：是被GC了，因为现在jvm并未使用引用计数算法
     */

}
