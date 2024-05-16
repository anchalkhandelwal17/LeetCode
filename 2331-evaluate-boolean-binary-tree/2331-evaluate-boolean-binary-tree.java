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
    public boolean evaluateTree(TreeNode root) {
        // TC : O(n)
        // SC : O(h)
        return dfs(root);
    }

    public boolean dfs(TreeNode root) {
        if(root.left == null && root.right == null){
            if(root.val == 0) return false;
            return true;   
        }
        boolean left = dfs(root.left);
        boolean right = dfs(root.right);

        if(root.val == 2){
            return left || right;
        }
        return left & right;
    }
}