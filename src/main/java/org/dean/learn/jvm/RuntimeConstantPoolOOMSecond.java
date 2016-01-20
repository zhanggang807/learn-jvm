package org.dean.learn.jvm;

/**
 * 代码清单 2-7 String.intern()返回引用的测试
 * jdk6返回两个false，jdk7返回一个false一个true
 * 对书中"java"字符串已经出现过一句表示不解
 * Created by Dean on 2016/1/3.
 */
public class RuntimeConstantPoolOOMSecond {

    public static void main(String[] args) {
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
    }

}
