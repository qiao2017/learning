package test.algorithm.sort;

import test.algorithm.util.IntArrayUtil;

/** 
 * @ClassName: HeapSort
 * @description: 
 * @author: 乔莹
 * @Date: 2019年2月23日 下午6:56:02
 */
public class HeapSort implements Sort{

    @Override
    public void sort(int[] arr) {
        if(arr.length < 2) {
            return;
        }
        buildMaxHeap(arr);

//        IntArrayUtil.displayArray(arr);
        for(int i = arr.length - 1; i > 0; i--) {
            IntArrayUtil.swap(arr, i, 0);
            heapify(arr, i);
        }
    }
    
    //建立一个大根堆
    private void buildMaxHeap(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            heapInsert(arr, i);
        }
    }
    
    //堆顶元素改变后，整个堆重新调整为大根堆, 堆大小为0~size-1
    public void heapify(int[] arr, int size) {
        int index = 0;
        //不越界继续
        while((index * 2 + 1) < size) {
            int left = index * 2 + 1;
            if(left == size - 1) {
                //无右子树
                if(arr[index] < arr[left]) {
                    IntArrayUtil.swap(arr, index, left);
                }else {
                    break;
                }
            }else {
                //有右子树
                if(arr[index] < arr[left] || arr[index] < arr[left + 1]) {
                    int max = arr[left] > arr[left + 1] ? left : left + 1;
                    IntArrayUtil.swap(arr, index, max);
                    index = max;
                }else {
                    break;
                }
            }
        }
    }
    
    //arr数组中， 0-index-1位置已形成大根堆，将index位置插入大根堆
    private void heapInsert(int[] arr, int index) {

        //父节点大，继续调整，直到父节点大于当前节点或index为根节点
        while(arr[index] > arr[(index-1)/2]) {
            IntArrayUtil.swap(arr, index, (index-1)/2);
            index = (index-1)/2;
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {-85, 46, -5, -29, -12, 75};
        IntArrayUtil.displayArray(arr);
        new HeapSort().sort(arr);
        IntArrayUtil.displayArray(arr);
        
    }

}
