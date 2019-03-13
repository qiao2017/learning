package test.thread.mashibing.pool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/** 
 * @ClassName: FutureTest
 * @description: 
 * @author: 乔莹
 * @Date: 2019年3月13日 下午10:29:06
 */
public class FutureTest {
    public static void main(String[] args) {
        FutureTask<Integer> task = new FutureTask<>(()->{
            TimeUnit.SECONDS.sleep(1);
            return 1;
        });
        
        new Thread(task).start();
        try {
            System.out.println(task.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
