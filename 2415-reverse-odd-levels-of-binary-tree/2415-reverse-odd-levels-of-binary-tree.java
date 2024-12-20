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
        // TC : O(n + (level * (n/2)/2))
        // SC : O(n + (level * n/2))
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 0;

        while(!q.isEmpty()){
            int size = q.size();
            List<TreeNode> list = new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode curr = q.poll();

                if(curr.left != null){
                    q.offer(curr.left);
                    if(level % 2 == 0) list.add(curr.left);
                }

                if(curr.right != null){
                    q.offer(curr.right);
                    if(level % 2 == 0) list.add(curr.right);
                }
            }
            if(level % 2 == 0){
                swap(list);
            }
            level++;
        }
        return root;
    }

    public void swap(List<TreeNode> list){
        int i=0, j=list.size()-1;

        while(i <= j){
            int temp = list.get(i).val;
            list.get(i).val = list.get(j).val;
            list.get(j).val = temp;
            i++;
            j--;
        }
    }
}