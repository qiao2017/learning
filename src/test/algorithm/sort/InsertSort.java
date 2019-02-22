package test.algorithm.sort;

import java.util.Arrays;

import test.algorithm.util.IntArrayUtil;

/**
 * 插入排序
 * 从第一个元素开始，该元素可以认为已经被排序；

        取出下一个元素，在已经排序的元素序列中从后向前扫描；
        
        如果该元素（已排序）大于新元素，将该元素移到下一位置；
        
        重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
        
        将新元素插入到该位置后；
        
        重复步骤2~5。
 * @author qiao
 *
 */
public class InsertSort implements Sort{

    @Override
    public void sort(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }
        
        for(int i = 1; i < arr.length; i++) {
            for(int j = i; j > 0; j--) {
                if(arr[j] < arr[j-1]) {
                    IntArrayUtil.swap(arr, j, j-1);
                }else {
                    break;
                }
            }
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        for(int i = 0; i < 10000; i++) {
            int[] arr = IntArrayUtil.generateRandomArray(10, 100);
            int[] arr2 = Arrays.copyOf(arr, arr.length);
            int[] arr3 = Arrays.copyOf(arr, arr.length);
            Arrays.sort(arr2);
            new InsertSort().sort(arr3);
            if(!IntArrayUtil.isEquals(arr2, arr3)) {
                System.out.println("Error!");
            }
        }
        System.out.println("SUCCESS");
    }

}
