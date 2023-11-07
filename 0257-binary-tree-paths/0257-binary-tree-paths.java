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
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> list = new ArrayList<>();
        if(root == null) return list;
        allPaths(root, list, "");
        return list;
    }

    public void allPaths(TreeNode root, List<String> list, String s){
        if(root == null) return;

        s += root.val;

        if(root.left == null && root.right == null){
            list.add(s);
        }

        s += "->";
        allPaths(root.left, list, s);
        allPaths(root.right, list, s);
    }
}