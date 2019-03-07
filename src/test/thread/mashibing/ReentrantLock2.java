package test.thread.mashibing;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/** 
 * @ClassName: ReentrantLock2
 * @description: 
 * @author: 乔莹
 * @Date: 2019年2月28日 下午9:48:12
 */
public class ReentrantLock2 {
    ReentrantLock lock = new ReentrantLock();
    void m1() {
        try {
            lock.lock();
            for(int i = 0; i < 10; i++) {
                TimeUnit.MILLISECONDS.sleep(1000);
                System.out.println(i);
                System.out.println(lock.isLocked());
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    void m2() {
        /*lock.lock();
        System.out.println("m2...");
        lock.unlock();*/
        boolean locked = false;
        
/*        try {
            locked = lock.tryLock(5, TimeUnit.SECONDS);
            System.out.println("m2 ..." + locked);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if(locked) lock.unlock();
        }*/
        
        try {
            //lock.lock();
            lock.lockInterruptibly(); //可以对interrupt()方法做出响应
            System.out.println("t2 start");
            TimeUnit.SECONDS.sleep(5);
            System.out.println("t2 end");
        } catch (InterruptedException e) {
            System.out.println("interrupted!");
        } finally {
            System.out.println(Thread.currentThread().holdsLock(lock));
        }
    }
    
    public static void main(String[] args) {
        ReentrantLock2 r = new ReentrantLock2();
        new Thread(()->{
            r.m1();
        }).start();

        
        Thread t2 = new Thread(()->{
            r.m2();
        });
        t2.start();
        
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.interrupt(); //打断线程2的等待
    }
}
