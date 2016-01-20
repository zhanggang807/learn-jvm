package org.dean.learn.jvm;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * VM Args: -XX:PermSize=10m -XX:MaxPermSize=10m
 * 代码清单 2-8 借助CGLib使用方法区出现内存溢出异常
 * 这些jvm参数已经在jdk8中废除了
 * Created by Dean on 2016/1/3.
 */
public class JavaMethodAreaOOM {

    public static void main(String[] args) {
        while (true){
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor(){
                public Object intercept (Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable{
                    System.out.println("this is proxy interceptor...");
                    return proxy.invokeSuper(obj, args);
                }
            });
            OOMObject obj = (OOMObject)enhancer.create();
            obj.check("zhang");
            System.out.println(obj.getClass().getCanonicalName());
        }
    }

    static class OOMObject{

        private String name;
        private String password;

        public boolean check(String name){
            System.out.println("this is base...");
            return name.equals("dean");
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }


}
