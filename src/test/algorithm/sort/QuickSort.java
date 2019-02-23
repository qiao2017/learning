package test.algorithm.sort;

import java.util.Random;
import java.util.function.IntUnaryOperator;

import test.algorithm.util.IntArrayUtil;

/**
 * 递归版快速排序
 * @author qiao
 *
 */
public class QuickSort implements Sort{
    private int[] partition(int[] arr, int start, int end, int position) {
        int less = start - 1;
        int current = start;
        int more = end + 1;
        int p = arr[position];
        while(current < more) {
            if(arr[current] < p) {
                IntArrayUtil.swap(arr, ++less, current++);
            }else if(arr[current] > p) {
                IntArrayUtil.swap(arr, --more, current);
            }else {
                current++;
            }
        }
        return new int[] {less + 1, more - 1};
    }
    
    private void quickSort(int[] arr, int start, int end) {
        if(start >= end) {
            return;
        }
        Random rand = new Random();
        int position = rand.nextInt(end-start+1) + start;
        int[] res = partition(arr, start, end, position);
        quickSort(arr, start, res[0] - 1);
        quickSort(arr, res[1] + 1, end);
    }
    
    @Override
    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }
    
    public static void main(String[] args) {
        int[] arr = IntArrayUtil.generateRandomArray(10, 100);
        IntArrayUtil.displayArray(arr);
        new QuickSort().sort(arr);
        IntArrayUtil.displayArray(arr);
    }
}
