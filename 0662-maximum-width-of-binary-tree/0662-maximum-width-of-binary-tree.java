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
 class Pair{
     TreeNode node;
     long idx;

     public Pair(TreeNode node, long idx){
         this.node = node;
         this.idx = idx;
     }
 }
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        // That's the binary tree property. You would just need to know it beforehand. left is n * 2, right is n * 2 + 1
        if(root == null) return 0;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 1));
        long ans = 0;

        while(!q.isEmpty()){
            int size = q.size();
            long first = 0;
            long second = 0;
            for(int i=0; i<size; i++){
                Pair pair = q.poll();
                TreeNode node = pair.node;
                if(i == 0) first = pair.idx;
                if(i == size - 1) second = pair.idx;

                if(node.left != null) q.offer(new Pair(node.left, 2*pair.idx));
                if(node.right != null) q.offer(new Pair(node.right, 2*pair.idx+1)); 
            }
            ans = Math.max(ans, second - first + 1);
        }
        return (int)ans;
    }
}