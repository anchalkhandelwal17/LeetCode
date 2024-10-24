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
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        return dfs(root1, root2);
    }

    public boolean dfs(TreeNode a, TreeNode b){
        // base case
        if(a == null || b == null){
            if(a == null && b == null) return true;
            else return false;
        }
        if(a.val != b.val) return false;

        return dfs(a.left, b.right) && dfs(a.right, b.left) ||
        (dfs (b.left, a.left) && dfs(b.right, a.right));
    }
}

// dfs can be applied, same logic like two trees and mirror of each other or not
// can be applied with a little tweak