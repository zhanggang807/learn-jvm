package org.dean.learn.singleton;

import java.io.Serializable;

/**
 * 单例模式
 * Created by Dean on 2016/4/21.
 */
public class SingletonPattern implements Serializable, Cloneable{

    private int age = 10;
    private String name = "java";

    private static class LazyHolder {
        private static final SingletonPattern INSTANCE = new SingletonPattern();
    }
    private SingletonPattern (){}

    public static final SingletonPattern getInstance() {
        return LazyHolder.INSTANCE;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    protected SingletonPattern clone() throws CloneNotSupportedException {
        SingletonPattern singletonPattern = (SingletonPattern)super.clone();
        singletonPattern.age = this.age;
        singletonPattern.name = new String(this.name);
        return singletonPattern;
    }

}
