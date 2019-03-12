package test.algorithm.offer.p11;

/** 
 * @ClassName: A
 * @description: 
 * @author: 乔莹
 * @Date: 2019年3月12日 下午11:13:24
 */
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        if(array == null || array.length < 1){
            throw new IllegalArgumentException();
        }
        
        int left = 0;
        int end = array.length;
        int mid = (left + end) / 2;
        while(mid < end){
            if(array[mid] > array[left]){
                left = mid;
            }else if(array[mid] < array[left]){
                end = mid;
            }else{
                int min = Integer.MAX_VALUE;
                for(int i = left; i <= end; i++){
                    min = min < array[i] ? min : array[i];
                }
                return min;
            }
            mid = (left + end) / 2;
        }
        return array[mid];
    }
}
