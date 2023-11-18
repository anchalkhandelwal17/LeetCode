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
    public TreeNode bstFromPreorder(int[] preorder) {
        
        TreeNode root = new TreeNode(preorder[0]);
        for(int i=1; i<preorder.length; i++){
            helper(root, preorder[i]);
        }
        return root;
    }

    public void helper(TreeNode root, int val){
        if(root == null) return;

        if(val > root.val){
            if(root.right != null){
                helper(root.right, val);
            }
            else{
                TreeNode node = new TreeNode(val);
                root.right = node;
                return;
            }
        }
        else if(val < root.val){
            if(root.left != null){
                helper(root.left, val);
            }
            else{
                TreeNode node = new TreeNode(val);
                root.left = node;
                return;
            }
        }
    }
}