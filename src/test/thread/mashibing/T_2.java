package test.thread.mashibing;

/** 
 * @ClassName: T_2
 * @description: 
 * @author: 乔莹
 * @Date: 2019年2月24日 下午4:30:32
 */
public class T_2 {
    volatile boolean running = true;
    public static void main(String[] args) {
        T_2 t = new T_2();
        new Thread(()->{
            t.m();
        }, "ttt").start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        t.running = false;
        System.out.println("t.running = " + t.running);

    }
    
    void m() {
        while(running) {
            
        }
        System.out.println(Thread.currentThread().getName() + " end");
    }
}
