package test.source;

import java.util.ArrayList;

/** 
 * @ClassName: ArrarList_S
 * @description: ArrayList源码解析
 * @author: 乔莹
 * @Date: 2019年2月24日 下午11:34:23
 */
public class ArrarList_S<E> extends ArrayList<E>{
    
    public static void main(String[] args) {
        ArrarList_S<Integer> as = new ArrarList_S<Integer>();
        as.add(6);
        System.out.println(as.get(0));
        System.out.println(as.geSize());
        int[] a = {};
        System.out.println(a.length);
        System.out.println(1 >> 1);
        int[] b = {};
        
        System.out.println(a == b);
    }
    
    int geSize() {
        return modCount;
    }
}
