package test.thread.mashibing;

import java.util.ArrayList;
import java.util.List;

/** 
 * @ClassName: MyContainer
 * @description: 
 * 实现一个容器，提供两个方法，add，size
 * 写两个线程，线程1添加10个元素到容器中，线程2实现监控元素的个数，当个数到5个时，线程2给出提示并结束
 * @author: 乔莹
 * @Date: 2019年2月24日 下午5:05:39
 */
public class MyContainer {
    List<Object> lists = new ArrayList<>();
    public void add(Object o) {
        lists.add(o);
    }
    public int size() {
        return lists.size();
    }
    
    public static void main(String[] args) throws InterruptedException {
        MyContainer mc = new MyContainer();
        final Object lock = new Object();
        Thread t1 = new Thread(()->{
            synchronized (lock) {
                while(true) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    mc.add(new Object());
                    System.out.println("add object");
                    if(mc.size() == 5) {
                        lock.notify();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        
                    }
                }
            }
        }, "1");
        
        
        Thread t2 = new Thread(()->{
            synchronized (lock) {
                System.out.println("t2启动");
                if(mc.size() != 5) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notifyAll();
                System.out.println("t2结束");
            }
        }, "2");
        
        t1.start();
        Thread.sleep(10000);
        t2.start();
    }
}
