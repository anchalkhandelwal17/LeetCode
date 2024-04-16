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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1){
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        dfs(root, val, depth, 1);
        return root;
    }

    public void dfs(TreeNode root, int val, int depth, int currDepth){
        if(root == null) return;
        if(currDepth == depth-1){
            TreeNode leftSubTree = root.left;
            TreeNode rightSubTree = root.right;
            root.left = new TreeNode(val);
            root.right = new TreeNode(val);
            root.left.left = leftSubTree;
            root.right.right = rightSubTree;
            return;
        }
        dfs(root.left, val, depth, currDepth+1);
        dfs(root.right, val, depth, currDepth+1);
    }
}