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
        StringBuilder sb = new StringBuilder();
        allPaths(root, list, sb);
        return list;
    }

    public void allPaths(TreeNode root, List<String> list, StringBuilder sb){
        if(root == null) return;

        int len = sb.length();
        sb.append(root.val);

        if(root.left == null && root.right == null){
            list.add(sb.toString());
        }

        sb.append("->");
        allPaths(root.left, list, sb);
        allPaths(root.right, list, sb);

        sb.setLength(len);
    }
}