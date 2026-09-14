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
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    public int dfs(TreeNode root, int pathMax){
        if(root == null) return 0;

        int cnt = root.val >= pathMax ? 1 : 0;

        cnt += dfs(root.left, Math.max(root.val, pathMax));
        cnt += dfs(root.right, Math.max(root.val, pathMax));

        return cnt;
    }
}