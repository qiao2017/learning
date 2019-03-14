package test.thread.mooc.synch;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/** 
 * @ClassName: ExchangerDemo
 * @description: 只能用于两个线程之间交换数据
 * 两个线程到达同步点后，相互交换数据
 * @author: 乔莹
 * @Date: 2019年3月14日 上午10:43:20
 */
public class ExchangerDemo {
    public static Exchanger<String> exchanger = new Exchanger<>();
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);
        
        service.execute(()->{
            try {
                String girl = exchanger.exchange("I'm Girl");
                System.out.println("Girl say: " + girl);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        
        service.execute(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
                String boy = exchanger.exchange("I'm Boy");
                System.out.println("Boy say: " + boy);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        
        service.shutdown();
    }
}
