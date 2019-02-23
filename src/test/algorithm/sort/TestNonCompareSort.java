package test.algorithm.sort;

import java.util.Arrays;

import test.algorithm.util.IntArrayUtil;

/** 
 * @ClassName: TestNonCompareSort
 * @description: 
 * @author: 乔莹
 * @Date: 2019年2月23日 下午8:02:33
 */
public class TestNonCompareSort {
    public static void main(String[] args) {
        Sort sort = new CountSort();
        for(int i = 0; i < 1000000; i++) {
            int[] arr = IntArrayUtil.generateRandomArray(20, 10);
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
