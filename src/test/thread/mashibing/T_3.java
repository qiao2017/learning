package test.thread.mashibing;

import java.util.ArrayList;
import java.util.List;

/** 
 * @ClassName: T_3
 * @description: 
 * @author: 乔莹
 * @Date: 2019年2月24日 下午4:41:51
 */
public class T_3 {
    volatile int count = 0; 
    /*synchronized*/ void m() {
        for(int i=0; i<10000; i++) count++;
    }
    
    public static void main(String[] args) {
        T_3 t = new T_3();
        
        List<Thread> threads = new ArrayList<Thread>();
        
        for(int i=0; i<10; i++) {
            threads.add(new Thread(t::m, "thread-"+i));
        }
        
        threads.forEach((o)->o.start());
        
        threads.forEach((o)->{
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        
        System.out.println(t.count);
        
        
    }
}
