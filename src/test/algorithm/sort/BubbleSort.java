package test.algorithm.sort;

import java.util.Arrays;

import test.algorithm.util.IntArrayUtil;

public class BubbleSort {
    public static void bubbleSort(int[] arr){
        if(arr == null || arr.length < 2) {
           return;
        }
        for(int i = arr.length - 1; i > 0; i--) {
            for(int j = 0; j < i; j++) {
                if(arr[j] > arr[j+1]) {
                    IntArrayUtil.swap(arr, j, j+1);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        for(int i = 0; i < 10000; i++) {
            int[] arr = IntArrayUtil.generateRandomArray(10, 100);
            int[] arr2 = Arrays.copyOf(arr, arr.length);
            int[] arr3 = Arrays.copyOf(arr, arr.length);
            Arrays.sort(arr2);
            BubbleSort.bubbleSort(arr3);
            if(!IntArrayUtil.isEquals(arr2, arr3)) {
                System.out.println("Error!");
            }
        }
    }
}
