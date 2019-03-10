package test.algorithm.offer;

import java.util.Stack;

/** 
 * @ClassName: P_3
 * @description: 用两个栈实现一个队列
 * @author: 乔莹
 * @Date: 2019年3月7日 下午11:24:52
 */
public class P_3 {
    public class Solution {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();
        
        public void push(int node) {
            stack1.push(node);
        }
        
        public int pop() {
            if(stack2.isEmpty()){
                while(!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }
    }
}
