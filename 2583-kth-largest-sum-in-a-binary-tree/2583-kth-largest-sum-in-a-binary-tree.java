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
    public long kthLargestLevelSum(TreeNode root, int k) {
        // TC : O(n + nlogk)
        // SC : O(n + k)
        if(root == null) return -1;
        Queue<TreeNode> q = new LinkedList<>();
        PriorityQueue<Long> pq = new PriorityQueue<>();

        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();
            long currSum = 0;

            for(int i=0; i<size; i++){
                TreeNode curr = q.poll();

                currSum += curr.val;
                if(curr.left != null) q.offer(curr.left);
                if(curr.right != null) q.offer(curr.right);
                
            }
            pq.offer(currSum);
            if(pq.size() > k) pq.poll();
        }
        return pq.size() < k ? -1 : pq.peek();
    }
}