package test.thread.mashibing.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/** 
 * @ClassName: FixedThreadPoolTest
 * @description: 
 * @author: 乔莹
 * @Date: 2019年3月13日 下午10:02:51
 */

/*public ThreadPoolExecutor(int corePoolSize,
        int maximumPoolSize,
        long keepAliveTime,
        TimeUnit unit,
        BlockingQueue<Runnable> workQueue,
        ThreadFactory threadFactory,
        RejectedExecutionHandler handler)*/
public class FixedThreadPoolTest {
    
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(4);
//        ExecutorService service = new ThreadPoolExecutor(0, 0, 0, null, null);// new ScheduledThreadPoolExecutor(0);
        for(int i = 0; i < 6; i++) {
            service.execute(()->{
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            });
        }
        System.out.println(service);
        service.shutdown();
        System.out.println(service.isTerminated());
        System.out.println(service.isShutdown());
        System.out.println(service);
        TimeUnit.SECONDS.sleep(6);
        System.out.println(service.isTerminated());
        System.out.println(service.isShutdown());
        System.out.println(service);
    }

}
