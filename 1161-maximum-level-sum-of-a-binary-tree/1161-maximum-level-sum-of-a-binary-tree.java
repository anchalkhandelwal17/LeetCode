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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int ansLevel = 0;
        int maxSum = Integer.MIN_VALUE;
        int level = 0;
        while(!q.isEmpty()){
            level++;
            int size = q.size();
            int currSum = 0;
            for(int i=0; i<size; i++){
                TreeNode curr = q.poll();
                currSum += curr.val;
                if(curr.left != null) q.offer(curr.left);
                if(curr.right != null) q.offer(curr.right);
            }
            if(currSum > maxSum){
                maxSum = currSum;
                ansLevel = level;
            }
        }
        return ansLevel;
    }
}