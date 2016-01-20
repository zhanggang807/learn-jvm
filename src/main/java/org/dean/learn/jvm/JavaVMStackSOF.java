package org.dean.learn.jvm;

/**
 * VM Args: -Xss128k
 * 代码清单 2-4 虚拟机栈和本地方法栈OOM测试
 * Created by Dean on 2016/1/3.
 */
public class JavaVMStackSOF {

    private int stacklength = 1;

    public void stackLeak(){
        stacklength ++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable{
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        }catch (Throwable e){
            System.out.println("stack length:" + oom.stacklength);//输出993
            throw e;
        }
    }

}
