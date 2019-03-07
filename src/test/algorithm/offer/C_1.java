package test.algorithm.offer;

/** 
 * @ClassName: C_1
 * @description: 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 *               每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @author: 乔莹
 * @Date: 2019年3月6日 下午11:07:25
 */
public class C_1 {
    public static void main(String[] args) {
        int[][] arr = new int[4][4];
    }

    public boolean Find(int target, int [][] array) {
        if(array == null || array.length == 0) {
            return false;
        }
        int row = 0;
        int column = array[0].length - 1;
        while(column >= 0 && row < array.length) {
            if(array[row][column] == target) {
                return true;
            }else if(array[row][column] > target) {
                column--;
            }else {
                row++;
            }
        }
        return false;
    }
    
}
