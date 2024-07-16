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
    boolean pBool = false;
    boolean qBool = false;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return root;
        TreeNode ans = null;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()){
            int size = que.size();
            for(int i=0; i<size; i++){
                TreeNode curr = que.poll();
                dfs(curr, p, q);
                if(pBool && qBool){
                    ans = curr;
                }
                pBool = false;
                qBool = false;

                if(curr.left != null) que.offer(curr.left);
                if(curr.right != null) que.offer(curr.right);
            }
        }
        return ans;
    }

    public void dfs(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return;
        if(root == p) pBool = true;
        if(root == q) qBool = true;

        dfs(root.left, p, q);
        dfs(root.right, p, q);
    }
}