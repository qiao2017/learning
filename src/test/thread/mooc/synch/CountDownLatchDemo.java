package test.thread.mooc.synch;

import java.util.concurrent.CountDownLatch;

/** 
 * @ClassName: CountDownLatchTest
 * @description: 
 * @author: 乔莹
 * @Date: 2019年3月14日 上午10:40:00
 */
public class CountDownLatchDemo {
    
    public static void main(String[] args) throws InterruptedException {
        new CountDownLatchDemo().go();
    }

    private void go() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);
        
        //依次创建三个线程并启动
        new Thread(new Task(latch), "Thread1").start();
        new Thread(new Task(latch), "Thread2").start();
        new Thread(new Task(latch), "Thread3").start();
//        latch.await();
        System.out.println("主线程到达" + System.currentTimeMillis());
    }
    
    class Task implements Runnable{
        private CountDownLatch latch;
        public Task(CountDownLatch latch) {
            this.latch = latch;
        }
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程" + Thread.currentThread().getName() + "已经到达" + System.currentTimeMillis());
            latch.countDown();
        }
        
    }
}
