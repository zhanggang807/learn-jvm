package org.dean.learn.jvm;

import java.io.*;
import java.lang.reflect.Constructor;

/**
 * 破坏单例模式
 * Created by Dean on 2016/4/21.
 */
public class BreakSingle {

    /** 可以从heap dump中看出来有四个实例了 */
    public static void main(String[] args) throws Exception{
        SingletonPattern a = SingletonPattern.getInstance();
        SingletonPattern a1 = SingletonPattern.getInstance();

        System.out.println("a == a1 : " + (a == a1));

        SingletonPattern b = getFromFile(a);
        SingletonPattern c = reflect();
        SingletonPattern d = a.clone();/** 克隆方式：已重写克隆方法 */

        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
        System.out.println("d = " + d);

        System.out.println("a == b : " + (a == b));
        System.out.println("a == c : " + (a == c));
        System.out.println("a == d : " + (a == d));
        System.out.println("b == c : " + (b == c));
        System.out.println("c == d : " + (c == d));
//        Thread.sleep(1000000000);
    }

    /** 序列化到文件 */
    public static SingletonPattern getFromFile(SingletonPattern singletonPattern) throws Exception{
        File file = new File("java.obj");
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(singletonPattern);//写到文件中
        oos.close();

        //从文件中读出来
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        SingletonPattern singletonPatternFromFile = (SingletonPattern) ois.readObject();
        ois.close();
        return singletonPatternFromFile;
    }

    /** 反射方法 */
    public static SingletonPattern reflect() throws Exception{
        Constructor con = SingletonPattern.class.getDeclaredConstructor();
        con.setAccessible(true);
        // 通过反射获取实例
        return (SingletonPattern) con.newInstance();
    }

}
