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
    public TreeNode replaceValueInTree(TreeNode root) {
        // TC : O(n + n)
        // SC : O(n + n)
        root.val = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int currSum = 0;
            List<TreeNode> list = new ArrayList<>();
            int size = q.size();

            for(int i=0; i<size; i++){
                TreeNode curr = q.poll();
                list.add(curr);

                if(curr.left != null){
                    currSum += curr.left.val;
                    q.offer(curr.left);
                }
                if(curr.right != null){
                    currSum += curr.right.val;
                    q.offer(curr.right);
                }
            }

            for(TreeNode node : list){
                int value = currSum;

                if(node.left != null) value -= node.left.val;
                if(node.right != null) value -= node.right.val;

                if(node.left != null) node.left.val = value;
                if(node.right != null) node.right.val = value;
            }
        }
        return root;
    }
}

