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
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;

        int[] mps = new int[1];
        mps[0] = Integer.MIN_VALUE;
        helper(root, mps);
        return mps[0];
    }

    public int helper(TreeNode root, int[] mps){
        if(root == null) return 0;

        int left = Math.max(0, helper(root.left, mps));
        int right = Math.max(0, helper(root.right, mps));

        mps[0] = Math.max(mps[0], left+right + root.val);

        return Math.max(left, right) + root.val;
    }
}