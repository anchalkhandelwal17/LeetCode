/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
     
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        kSmall(root, pq, k);
        return pq.peek();
    }
    
    public void kSmall(TreeNode root, PriorityQueue<Integer> pq, int k){
        if(root == null) return;
        
        pq.offer(root.val);
        if(pq.size() > k) pq.poll();
        
        kSmall(root.left, pq, k);
        kSmall(root.right, pq, k);
    }
}