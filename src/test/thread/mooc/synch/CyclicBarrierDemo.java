package test.thread.mooc.synch;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/** 
 * @ClassName: CyclicBarrierDemo
 * @description: 阻塞当前线程，等待其他线程
 * ,且会阻塞自己当前线程，所有线程必须到达栅栏位置后，才能继续执行
 * 
 * 所有线程到达栅栏处，可以触发另外一个预先设置的线程
 * @author: 乔莹
 * @Date: 2019年3月14日 上午10:41:10
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) throws InterruptedException {
        new CyclicBarrierDemo().go();
    }
    
    private void go() throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        new Thread(()->{
            System.out.println("线程" + Thread.currentThread().getName() + "到达" + System.currentTimeMillis());
            try {
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("线程" + Thread.currentThread().getName() + "开始处理" + System.currentTimeMillis());

        }, "Thread1").start();
        Thread.sleep(1000);
        new Thread(()->{
            System.out.println("线程" + Thread.currentThread().getName() + "到达" + System.currentTimeMillis());

            try {
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("线程" + Thread.currentThread().getName() + "开始处理" + System.currentTimeMillis());

        }, "Thread2").start();
        Thread.sleep(1000);
        new Thread(()->{
            System.out.println("线程" + Thread.currentThread().getName() + "到达" + System.currentTimeMillis());

            try {
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("线程" + Thread.currentThread().getName() + "开始处理" + System.currentTimeMillis());

        }, "Thread3").start();
    }
}
