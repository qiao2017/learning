package test.algorithm.sort;

import java.util.Arrays;

import test.algorithm.util.IntArrayUtil;

/**
 * 希尔排序
 * 
 * @author qiao
 *
 */
public class ShellSort implements Sort{

    @Override
    public void sort(int[] arr) {
//        TODO
    }
    
    public static void main(String[] args) throws InterruptedException {
        for(int i = 0; i < 10000; i++) {
            int[] arr = IntArrayUtil.generateRandomArray(10, 100);
            int[] arr2 = Arrays.copyOf(arr, arr.length);
            int[] arr3 = Arrays.copyOf(arr, arr.length);
            Arrays.sort(arr2);
            new ShellSort().sort(arr3);
            if(!IntArrayUtil.isEquals(arr2, arr3)) {
                System.out.println("Error!");
            }
        }
        System.out.println("SUCCESS");
    }

}
