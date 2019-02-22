package test.algorithm.util;
/**
 * @author 乔莹
 * @version TODO
 * @time  2019年2月3日 上午10:53:17
 * @copyright qiao
 */
public class IntArrayUtil {
    public static void displayArray(int[] arr) {
        System.out.print("[");
        for(int i = 0; i < arr.length; i++) {
            if(i == arr.length -1) {
                System.out.print(arr[i]);
            }else {
                System.out.print(arr[i] + ", ");
            }
        }
        System.out.println("]");
    }
    
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static boolean isEquals(int[] arr1, int[] arr2) {
        if(arr1.length != arr2.length ) {
            return false;
        }
        for(int i = 0; i < arr1.length; i++) {
            if(arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
    
    public static int[] generateRandomArray(int size, int value){
        int randomSize = (int)(Math.random() * (size + 1));
        int[] arr = new int[randomSize];
        for(int i = 0; i < randomSize; i++) {
            int randomValue = (int) (Math.random() * (value + 1)) - (int) (Math.random() * (value + 1));
            arr[i] = randomValue;
        }
        return arr;
    }
}
