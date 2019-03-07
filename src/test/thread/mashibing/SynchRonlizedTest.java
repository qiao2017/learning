package test.thread.mashibing;

/** 
 * @ClassName: SynchRonlizedTest
 * @description: 
 * @author: 乔莹
 * @Date: 2019年2月24日 下午4:11:37
 */
public class SynchRonlizedTest implements Runnable{
    private int count = 10;

    @Override
    public /*synchronized*/ void run() {
        count--;
        System.out.println(Thread.currentThread().getName()
                + " count = " + count);
    }
    
    public static void main(String[] args) {
        SynchRonlizedTest st = new SynchRonlizedTest();
        for(int i = 0; i < 10; i++) {
            new Thread(st, "THREAD_" + i).start();
        }
    }
}
