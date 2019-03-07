package test.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** 
 * @ClassName: ThreeSum
 * @description: 
 * @author: 乔莹
 * @Date: 2019年3月3日 下午4:35:53
 */
public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Set<String> resset = new HashSet<>();
        int[] numbers = Arrays.copyOf(nums, nums.length);
        Arrays.sort(numbers);
        int j = 0;
        for(int i = 1; i < numbers.length; i++) {
            if(numbers[j] != numbers[i]) {
                numbers[++j] = numbers[i];
            }
        }
        
        //排序后， 0~j为有效范围
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i <= j; i++) {
            set.add(numbers[i]);
        }
        
        for(int i = 0; i < j; i++) {
            for(int k = 1; k <= j; k++) {
                if(set.contains(-(numbers[i] + numbers[k]))) {
                    List<Integer> l = new ArrayList<>();
                    l.add(numbers[i]);
                    l.add(numbers[k]);
                    l.add(-(numbers[i] + numbers[k]));
                    int max = Math.max(Math.max(numbers[i], numbers[k]), -(numbers[i] + numbers[k]));
                    int min = Math.min(Math.min(numbers[i], numbers[k]), -(numbers[i] + numbers[k]));
                    String str = "" + min + (0-max-min) + max;
                    System.out.println(str);
                    resset.add(str);
                    continue;
                }
            }
        }
        
        System.out.println(resset.size());
        return res;
    }
    
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> ll = threeSum(nums);
        System.out.println(ll.size());
    }
    
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
}
