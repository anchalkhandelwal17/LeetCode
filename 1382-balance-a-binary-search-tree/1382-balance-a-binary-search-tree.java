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
    public TreeNode balanceBST(TreeNode root) {
        // TC : O(n)
        // SC : O(n)
        // int check = heightDfs(root);

        // if(check != -1) return root;
        List<TreeNode> list = new ArrayList<>();
        inOrderDfs(root, list);
        return balancedBstDfs(list, 0, list.size()-1);
    }
    
    public TreeNode balancedBstDfs(List<TreeNode> list, int s, int e){
        if(s > e) return null;
        int m = (s + e)/2;
        TreeNode root = list.get(m);
        root.left = balancedBstDfs(list, s, m-1);
        root.right = balancedBstDfs(list, m+1, e);
        return root;
    }

    public void inOrderDfs(TreeNode root, List<TreeNode> list){
        if(root == null) return;
        inOrderDfs(root.left, list);
        list.add(root);
        inOrderDfs(root.right, list);
    }

    public int heightDfs(TreeNode root){
        if(root == null) return 0;

        int leftH = heightDfs(root.left);
        if(leftH == -1) return -1;
        int rightH = heightDfs(root.right);
        if(rightH == -1) return -1;

        if(Math.abs(leftH - rightH) > 1) return -1;
        return 1 + Math.max(leftH, rightH);
    }
}