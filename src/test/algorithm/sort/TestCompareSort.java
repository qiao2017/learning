package test.algorithm.sort;

import java.util.Arrays;

import test.algorithm.util.IntArrayUtil;

/** 
 * @ClassName: TestSort
 * @description: 
 * @author: 乔莹
 * @Date: 2019年2月23日 下午6:51:14
 */
public class TestCompareSort {
    public static void main(String[] args) {
        Sort sort = new HeapSort();
//        Sort sort = new QuickSort();
        for(int i = 0; i < 1000000; i++) {
            int[] arr = IntArrayUtil.generateRandomArray(10, 100);
            int[] arr2 = Arrays.copyOf(arr, arr.length);
            int[] arr3 = Arrays.copyOf(arr, arr.length);
            Arrays.sort(arr2);
            sort.sort(arr3);
            if(!IntArrayUtil.isEquals(arr2, arr3)) {
                System.out.println("Error!");
                IntArrayUtil.displayArray(arr);
                IntArrayUtil.displayArray(arr2);
                IntArrayUtil.displayArray(arr3);
                break;
            }
        }
        System.out.println("SUCCESS");
    }
}
