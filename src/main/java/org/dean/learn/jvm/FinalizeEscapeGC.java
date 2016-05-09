package org.dean.learn.jvm;

/**
 * 此代码演示了两点：
 * 1. 对象可以在被GC时自我拯救
 * 2. 这种自我拯救的机会只有一次，因为一个对象的finalize方法最多只会被系统自动调用一次
 * 代码清单 3-2 一次对象自我拯救的演示
 * Created by Dean on 2016/1/18.
 */
public class FinalizeEscapeGC {

    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive(){
        System.out.println("yes, I am still alive :) ");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed!");
        FinalizeEscapeGC.SAVE_HOOK = this;//拯救自已
    }

    public static void main(String[] args) throws Throwable{
        SAVE_HOOK = new FinalizeEscapeGC();
        SAVE_HOOK = null;
        System.gc();
        //因为finalize方法优先级很低，所以暂停0.5秒以等待它
        Thread.sleep(500);
        if (SAVE_HOOK != null){
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no, i am dead :( ");
        }

        //下面这段代码与上面的完全相同，但是这次自救失败了
        SAVE_HOOK = null;
        System.gc();
        //因为finalize方法优先级很低，所以暂停0.5秒以等待它
        Thread.sleep(500);

        if (SAVE_HOOK != null){
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no, i am dead :( ");
        }
    }

}
