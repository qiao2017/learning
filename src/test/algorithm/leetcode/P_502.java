package test.algorithm.leetcode;

import java.util.PriorityQueue;

/** 
 * @ClassName: P_502
 * @description: 
 * @author: 乔莹
 * @Date: 2019年2月27日 下午8:28:59
 */
public class P_502 {
    public static int getMostCapital(int K, int W, int[] Profits, int[] Capital) {
        Node[] nodes = new Node[Profits.length];
        for(int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(Profits[i], Capital[i]);
        }
        
        PriorityQueue<Node> minCostQueue = new PriorityQueue<>((final Node n1, final Node n2)->{
            return n1.cost - n2.cost;
        });
        
        PriorityQueue<Node> maxProfitQueue = new PriorityQueue<>((final Node n1, final Node n2)->{
            return n2.profit - n1.profit;
        });
        
        for(int i = 0; i < nodes.length; i++) {
            if(W >= nodes[i].cost) {
                maxProfitQueue.add(nodes[i]);
            }else {
                minCostQueue.add(nodes[i]);
            }
        }
        
        while(K-- > 0) {
            if(maxProfitQueue.isEmpty()) {
                break;
            }
            W += maxProfitQueue.poll().profit;
            while(!minCostQueue.isEmpty()) {
                Node node = minCostQueue.peek();
                if(node.cost <= W) {
                    maxProfitQueue.add(minCostQueue.poll());
                }else {
                    break;
                }
            }
        }
        return W;
    }
    
    public static void main(String[] args) {
        int[] costs = {0, 1, 1};
        int[] profits = {1, 2, 3};
        System.out.println(getMostCapital(2, 0, profits, costs));
    }
    
    
    
    public static class Node{
        public int profit;
        public int cost;
        public Node(int profit, int cost) {
            this.profit = profit;
            this.cost = cost;
        }
    }
}


