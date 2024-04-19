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
    public int sumOfLeftLeaves(TreeNode root) {
        return dfs(root, false);
    }
    public int dfs(TreeNode root, boolean isLeft){
        int sum = 0;
        if(root == null) return sum;
        if(root.left == null && root.right == null && isLeft){
            sum += root.val;
        }
        sum += dfs(root.left, true);
        sum += dfs(root.right, false);
        return sum;
    }
}