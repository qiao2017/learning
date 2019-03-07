package test.thread.mashibing;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/** 
 * @ClassName: MyContainer5
 * @description: 
 * @author: 乔莹
 * @Date: 2019年2月25日 下午9:20:01
 */
public class MyContainer5 {
    volatile List<Object> lists = new ArrayList<>();
    public void add(Object o) {
        lists.add(o);
    }
    public int size() {
        return lists.size();
    }
    
    public static void main(String[] args) {
        MyContainer5 c = new MyContainer5();
        CountDownLatch latch = new CountDownLatch(1);
        
        new Thread(()->{
            System.out.println("t2启动");
            if(c.size() != 5) {
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            System.out.println("t2结束");
        }, "t2").start();
        
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        new Thread(()->{
            System.out.println("t1启动");
            for (int i = 0; i < 10; i++) {
                c.add(new Object());
                System.out.println("add " + i);

                if (c.size() == 5) {
                    // 打开门闩，让t2得以执行
                    latch.countDown();
                }

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } 
        },"t1").start();
    }
}
