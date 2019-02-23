package test.algorithm.nowcoder;

import test.algorithm.util.IntArrayUtil;

/**
 * 荷兰国旗问题
 * @author qiao
 *
 */
public class NetherlandsFlag {
    public static void partition(int[] arr, int l, int r, int p) {
        int less = l - 1;
        int more = r + 1;
        int current = l;
        while(current < more) {
//            IntArrayUtil.displayArray(arr);
            if(arr[current] < p) {
                IntArrayUtil.swap(arr, ++less, current++);
            }else if(arr[current] > p){
                IntArrayUtil.swap(arr, --more, current);
            }else {
                current++;
            }
        }
        System.out.println(less);
        System.out.println(more);
    }
    public static void main(String[] args) {
//        int[] arr = IntArrayUtil.generateRandomArray(10, 100);
        int[] arr = {-68, 45, 19, -55, 59, -8, 7, 60};
        IntArrayUtil.displayArray(arr);
        partition(arr, 0, arr.length-1, 19);
        IntArrayUtil.displayArray(arr);
    }
}
