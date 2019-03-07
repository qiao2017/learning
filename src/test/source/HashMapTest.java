package test.source;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/** 
 * @ClassName: HashMapTest
 * @description: 
 * @author: 乔莹
 * @Date: 2019年3月3日 下午12:25:10
 */
public class HashMapTest {
    
    public static void main(String[] args) throws InterruptedException {
        HashMap<Object, Object> hm = new HashMap<>();
/*        hm.put(null, null);
        hm.put(null, null);
        System.out.println(hm.size());*/
        for(int i = 0; i < 10; i++) {
            new Thread(()->{
                for(int j = 0; j < 100; j++) {
                    hm.put(new Object(), new Object());
                }
            }).start();
        }
        
        TimeUnit.SECONDS.sleep(2);
        System.out.println(hm.size());
    }
}
