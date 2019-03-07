package test.thread.mashibing;

/** 
 * @ClassName: T
 * @description: 同步方法和非同步方法可以同时调用
 * @author: 乔莹
 * @Date: 2019年2月24日 下午4:16:17
 */
public class T {
    public synchronized void m1() {
        System.out.println(Thread.currentThread().getName() + " m1 start...");
        
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println(Thread.currentThread().getName() + " m1 end...");
    }

    public void m2() {
        System.out.println(Thread.currentThread().getName() + " m2 start...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " m2 end...");
    }
    
/* 输出结果：
t1 m1 start...
t2 m2 start...
t2 m2 end...
t1 m1 end...
*/
    public static void main(String[] args) {
        T t = new T();
        new Thread(() -> {
            t.m1();
        }, "t1").start();
        
        new Thread(() -> {
            t.m2();
        }, "t2").start();
    }
}
