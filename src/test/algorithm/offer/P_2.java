package test.algorithm.offer;

/** 
 * @ClassName: P_2
 * @description: 
 * 输入某二叉树的前序遍历和中序遍历的结果，
 * 请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
 * 则重建二叉树并返回。
 * @author: 乔莹
 * @Date: 2019年3月6日 下午11:30:17
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {val = x;}
}

public class P_2 {
    public static void main(String[] args) {
        int[] pre = new int[] {3,5,6,8};
        int[] in = new int[] {5,3,8,6};
        TreeNode tree = reConstructBinaryTree(pre, in);
        System.out.println(8);
    }
    
    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre == null || in == null || pre.length == 0 || in.length == 0) {
            return null;
        }

        return constructBinaryTree(pre, 0, pre.length, in, 0);
    }
    
    public static TreeNode constructBinaryTree(int[] pre, int lstart, int length,
                                                int[] in, int rstart) {
        if(length <= 0) {
            return null;
        }
        if(length == 1) {
            return new TreeNode(pre[lstart]);
        }
        TreeNode root = new TreeNode(pre[lstart]);
        int rootPos = rstart;
        for(int i = 0; i < length; i++) {
            if(pre[lstart] == in[i + rstart]) {
                rootPos = i + rstart;
                break;
            }
        }
        
        int leftLength = rootPos-rstart;
        int rightLength = length - leftLength - 1;
       
        
        TreeNode left = constructBinaryTree(pre, lstart+1, leftLength, in, rstart);
        TreeNode right = constructBinaryTree(pre, lstart + leftLength + 1, rightLength, in, rootPos + 1);
        root.left = left;
        root.right = right;
        
        return root;
    }
}
