package test.pattern.adapter;

public class Client {
    public static void main(String[] args) {
        ScoreOperation operation;
        operation = (ScoreOperation) XMLUtil.getBean();
        int[] scores = {1, 27, 90, 82, 37, 48, 99, 100 ,64};
        operation.sort(scores);
        System.out.println("成绩排序结果：");
        for(int i : scores) {
            System.out.print(i + " ");
        }
        
        System.out.println("\n");
        System.out.println("查找成绩90：");
        System.out.println(operation.search(scores, 90));
    }
}
