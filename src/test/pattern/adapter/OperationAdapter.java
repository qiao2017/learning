package test.pattern.adapter;

public class OperationAdapter implements ScoreOperation{
    private QuickSort sortObj;
    private BinarySearch searchObj;
    public OperationAdapter() {
        sortObj = new QuickSort();
        searchObj = new BinarySearch();
    }
    @Override
    public void sort(int[] arr) {
        sortObj.quickSort(arr);
    }

    @Override
    public int search(int[] arr, int key) {
        return searchObj.binarySearch(arr, key);
    }

}
