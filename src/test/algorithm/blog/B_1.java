package test.algorithm.blog;

import java.util.HashMap;
import java.util.Map.Entry;

/** 
 * @ClassName: TopKNumber
 * @description: 给定一个int数组，找出出现次数最多的数字
 * https://www.cnblogs.com/baiqiantao/p/10086444.html
 * @author: 乔莹
 * @Date: 2019年3月10日 下午4:49:17
 */
public class B_1 {
    public static void main(String[] args) {
        int[] array = {1, 1, 1, 1, 5, 1, 5, 1, 5, 5, 5};
        System.out.println(mostNum(array));

        double a =  0.2;
        a = 0.2 + 0.1 - 0.1;
        double b =  0.2;
        double c = 0.2;
        System.out.println(a);
        System.out.println(a == b);
        System.out.println(b == c);
        Integer.valueOf(1000);
        System.out.println(Integer.valueOf(10) == new Integer(10));
        System.out.println(Integer.valueOf(1000) == Integer.valueOf(1000));
        System.out.println(0.06+0.05);
    }
    
    public static int mostNum(int[] arr) {
        if(arr == null || arr.length < 1) {
            throw new IllegalArgumentException("不合法的参数");
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i])) {
                map.replace(arr[i], map.get(arr[i]) + 1);
            }else {
                map.put(arr[i], 1);
            }
        }
        int key = arr[0];
        for(Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() > map.get(key)) {
                key = entry.getKey();
            }
        }
        return key;
    }
    
}
