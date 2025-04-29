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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // TC : O(n)
        // SC : O(h)
        return solve(root, targetSum);
    }

    public boolean solve(TreeNode root, int sum){
        if(root == null) return false;
        if(root.left == null && root.right == null){
            if(sum - root.val == 0) return true;
            return false;
        }

        boolean left = solve(root.left, sum - root.val);
        boolean right = solve(root.right, sum - root.val);

        return left || right;
    }
}