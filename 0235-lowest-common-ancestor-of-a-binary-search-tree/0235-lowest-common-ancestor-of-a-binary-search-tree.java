/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // TC : O(log n), SC : O(log n)
        // if reached null return itself
        if(root == null) return null;

        int currVal = root.val;

        // if p.val < current root.val and q.val < current root.val
        //go to left as LCA lies in left
        if(p.val < currVal && q.val < currVal)
            return lowestCommonAncestor(root.left, p, q);
        
        // if p.val > current root.val and q.val > current root.val
        //go to right as LCA lies in right
        else if(p.val > currVal && q.val > currVal)
            return lowestCommonAncestor(root.right, p, q);

        // else return current root as it is the LCA
        else
            return root;
    }
}