package test.thread.mashibing;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/** 
 * @ClassName: MyCont
 * @description: 
 * @author: 乔莹
 * @Date: 2019年2月24日 下午7:15:59
 */
public class MyContainer4 {

    //添加volatile，使t2能够得到通知
    volatile List lists = new ArrayList();

    public void add(Object o) {
        lists.add(o);
    }

    public int size() {
        return lists.size();
    }
    
    public static void main(String[] args) {
        MyContainer4 c = new MyContainer4();
        
        final Object lock = new Object();
        
        new Thread(() -> {
            synchronized(lock) {
                System.out.println("t2启动");
                if(c.size() != 5) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("t2 结束");
                //通知t1继续执行
                lock.notify();
            }
            
        }, "t2").start();
        
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        new Thread(() -> {
            System.out.println("t1启动");
            synchronized(lock) {
                for(int i=0; i<10; i++) {
                    c.add(new Object());
                    System.out.println("add " + i);
                    
                    if(c.size() == 5) {
                        lock.notify();
                        //释放锁，让t2得以执行
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "t1").start();
        
        
    }
}
