package test.thread.mashibing;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/** 
 * @ClassName: LockTest
 * @description: 测试ReentrantLock、synchronized、AtomicInteger
 * @author: 乔莹
 * @Date: 2019年2月25日 下午12:36:11
 */
public class LockTest {
    ReentrantLock lock = new ReentrantLock();
    AtomicInteger ai = new AtomicInteger(0);
    
    int count = 0;
    public void m1() {
        lock.lock();
        for(int i = 0; i < 10000; i++) {
            count++;
        }
        lock.unlock();
    }
    synchronized public void m2() {
        for(int i = 0; i < 10000; i++) {
            count++;
        }
    }
    public void m3() {
        for(int i = 0; i < 10000; i++) {
            ai.getAndIncrement();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        for(int i = 0; i < 10; i++) {
            test(i, 100);
        }
    }
    
    public static void test(int index, int times) throws InterruptedException {
        System.out.println(String.format("第%d次执行", index+1));
        long now1 = System.currentTimeMillis();
        LockTest test = new LockTest();
        for(int i = 0; i < times; i++) {
            new Thread(()->{
                test.m1();
                test.m1();
                test.m1();
            }).start();
        }
        System.out.println(System.currentTimeMillis() - now1);
        
        long now2 = System.currentTimeMillis();
        LockTest test2 = new LockTest();
        for(int i = 0; i < times; i++) {
            new Thread(()->{
                test2.m2();
                test2.m2();
                test2.m2();
            }).start();
        }
        System.out.println(System.currentTimeMillis() - now2);
        
        long now3 = System.currentTimeMillis();
        LockTest test3 = new LockTest();
        for(int i = 0; i < times; i++) {
            new Thread(()->{
                test3.m3();
                test3.m3();
                test3.m3();
            }).start();
        }
        System.out.println(System.currentTimeMillis() - now3);
        
        Thread.sleep(1000);
        System.out.println(test.count);
        System.out.println(test2.count);
        System.out.println(test3.ai);
        System.out.println("\n\n\n");
    }
}
