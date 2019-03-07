package test.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/** 
 * @ClassName: TwoSum
 * @description: https://leetcode-cn.com/problems/two-sum/
 * @author: 乔莹
 * @Date: 2019年3月3日 下午4:19:35
 */
public class TwoSum {
    public static int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < numbers.length; i++) {
            if(map.get((target - numbers[i])) != null) {
                return new int[]{i, map.get((target - numbers[i]))};
            }
            map.put(numbers[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] res = twoSum(nums, target);
        System.out.println(res[0] + " " + res[1]);
    }
}
