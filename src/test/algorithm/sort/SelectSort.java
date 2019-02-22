package test.algorithm.sort;

import java.util.Arrays;

import test.algorithm.util.IntArrayUtil;

public class SelectSort implements Sort{

    @Override
    public void sort(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }
        
        for(int i = arr.length - 1; i > 0; i--) {
            int max = 0;
            for(int j = 1; j <= i; j++) {
                if(arr[max] < arr[j]) {
                    max = j;
                }
            }
            
            IntArrayUtil.swap(arr, i, max);
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        for(int i = 0; i < 10000; i++) {
            int[] arr = IntArrayUtil.generateRandomArray(10, 100);
            int[] arr2 = Arrays.copyOf(arr, arr.length);
            int[] arr3 = Arrays.copyOf(arr, arr.length);
            Arrays.sort(arr2);
            new SelectSort().sort(arr3);
            if(!IntArrayUtil.isEquals(arr2, arr3)) {
                System.out.println("Error!");
            }
        }
        System.out.println("SUCCESS");
    }

}
