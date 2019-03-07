package test.thread.mashibing;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/** 
 * @ClassName: T_4
 * @description: AtomXXX
 * @author: 乔莹
 * @Date: 2019年2月24日 下午4:44:35
 */
public class T_4 {
    AtomicInteger count = new AtomicInteger(0);
    void m() {
        for(int i = 0; i < 1000; i++) {
            count.incrementAndGet();
        }
    }
    
    public static void main(String[] args) {
        T_4 t = new T_4();
        List<Thread> threads = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            threads.add(new Thread(()->{
                t.m();
            }, "THREAD" + i));
        }
        
        for (Thread thread : threads) {
            thread.start();
        }        
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        System.out.println(t.count);
    }
}
