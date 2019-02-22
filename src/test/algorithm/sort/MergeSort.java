package test.algorithm.sort;

import java.util.Arrays;

import test.algorithm.util.IntArrayUtil;

/**
 * 归并排序
 * 
 * @author qiao
 *
 */
public class MergeSort implements Sort{

    @Override
    public void sort(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }
    private void mergeSort(int[] arr, int start, int right) {
        if(start == right) {
            return;
        }
        int mid = (start + right) / 2;
        System.out.println(start + "  " + right);
        mergeSort(arr, start, mid);
        mergeSort(arr, mid+1, right);
        merge(arr, start, mid, mid+1, right);
    }
    private void merge(int[] arr, int leftStart, int leftEnd, 
            int rightStart, int rightEnd) {
        int[] temp = new int[rightEnd-leftStart+1];
        int i = 0;
        while(leftStart <= leftEnd && rightStart <= rightEnd) {
            if(arr[leftStart] < arr[rightStart]) {
                temp[i++] = arr[leftStart++];
            }else {
                temp[i++] = arr[rightStart++];
            }
        }
        while(leftStart <= leftEnd) {
            temp[i++] = arr[leftStart++];
        }
        while(rightStart <= rightEnd) {
            temp[i++] = arr[rightStart++];
        }
        
        for(i = temp.length - 1; i >= 0; i--) {
            arr[rightEnd--] = temp[i];
        }
    }
    public static void main(String[] args) throws InterruptedException {
        for(int i = 0; i < 10000; i++) {
            int[] arr = IntArrayUtil.generateRandomArray(10, 100);
            int[] arr2 = Arrays.copyOf(arr, arr.length);
            int[] arr3 = Arrays.copyOf(arr, arr.length);
            Arrays.sort(arr2);
            new MergeSort().sort(arr3);
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
