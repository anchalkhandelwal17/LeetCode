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
    public String smallestFromLeaf(TreeNode root) {
        StringBuilder curr = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        dfs(root, curr, ans);
        return ans.toString();
    }
    public void dfs(TreeNode root, StringBuilder curr, StringBuilder ans){
        if(root == null) return;
        curr.insert(0, (char)(root.val+97));
        if(root.left == null && root.right == null){
            if(ans.length() == 0){
                ans.append(curr);
            }
            else if(curr.toString().compareTo(ans.toString()) < 0){
                ans.delete(0, ans.length());
                ans.append(curr);
            }
        }
        dfs(root.left, curr, ans);
        dfs(root.right, curr, ans);
        curr.deleteCharAt(0);
    }
}