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
    public TreeNode reverseOddLevels(TreeNode root) {
        // TC : O(n)
        // SC : O(n)
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 0;
        while(!q.isEmpty()){
            level++;
            int size = q.size();

            for(int i=0; i<size; i++){
                TreeNode curr = q.poll();
                if(curr.left != null) q.offer(curr.left);
                if(curr.right != null) q.offer(curr.right);
            }

            if(level % 2 == 1 && !q.isEmpty()){
                LinkedList<TreeNode> list = new LinkedList<>();
                for(int i=0; i<q.size(); i++){
                    TreeNode curr = q.poll();
                    list.add(curr);
                    q.offer(curr);
                }

                int i = 0;
                int j = list.size()-1;

                while(i <= j){
                    int ithNodeVal = list.get(i).val;
                    int jthNodeVal = list.get(j).val;

                    list.get(i).val = jthNodeVal;
                    list.get(j).val = ithNodeVal;

                    i++;
                    j--;
                }
            }
        }
        return root;
    }
}