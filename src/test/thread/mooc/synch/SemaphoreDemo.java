package test.thread.mooc.synch;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/** 
 * @ClassName: SemaphoreDemo
 * @description: 控制某个资源可同时被访问的线程数
 * @author: 乔莹
 * @Date: 2019年3月14日 上午10:42:51
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        
        final Semaphore semp = new Semaphore(5);
        
        //模拟20个客户端访问
        for(int index = 0; index < 20; index++) {
            final int NO = index;
            Runnable run = ()->{
                try {
                    semp.acquire();
                    System.out.println("Accessing：" + NO);
                    Thread.sleep((long)(Math.random() * 10000));
                }catch (Exception e) {
                    
                }finally {
                    System.out.println("Exit：" + NO);
                    semp.release();
                }
            };
            
            exec.execute(run);
        }
        exec.shutdown();
        
    }
}
