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
    int prev = 0;
    public TreeNode bstToGst(TreeNode root) {
        dfs(root);
        return root;
    }
    public void dfs(TreeNode root){
        if(root == null) return ;
        dfs(root.right);
        root.val = root.val + prev;
        prev = root.val;
        dfs(root.left);
    }
}