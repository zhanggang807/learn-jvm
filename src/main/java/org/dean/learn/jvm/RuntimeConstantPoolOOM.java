package org.dean.learn.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args: -XX:PermSize=10m -XX:MaxPermSize=10m
 * 代码清单 2-6 运行时常量池导致的内存溢出异常
 * jdk7以上运行内存一直飙升。jdk6会报OutOfMemoryError PermGen space
 * 因为jdk7不会复制到永久代中，而jdk6是复制到永久代并返回永久代的引用
 * Created by Dean on 2016/1/3.
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
        //使用list保持着常量池引用，避免Full GC回收常量池行为
        List<String> list = new ArrayList<String>();
        //10MB的PermSize在integer范围内足够产生OOM了
        int i = 0;
        while (true){
            list.add(String.valueOf(i++).intern());
        }
    }

}
