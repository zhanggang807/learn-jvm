package org.dean.learn.jvm;

/**
 * VM Args: -Xss2M(这时候不妨设置大些)
 * 代码清单 2-5 创建线程导致内存溢出异常
 * 注意：这个程序不要在windows平台上运行。
 * 因为线程是绑定到win内核线程上的，会造成系统假死
 * Created by Dean on 2016/1/3.
 */
public class JavaVMStackOOM {

    private void dontStop(){
        while (true){

        }
    }

    public void stackLeakByThread(){
        while(true){
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) throws Throwable{
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }

}
