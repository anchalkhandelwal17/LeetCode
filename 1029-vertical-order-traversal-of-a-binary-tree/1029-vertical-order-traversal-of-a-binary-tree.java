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
     int row;
     int col;

     public Pair(TreeNode node, int row, int col){
         this.node = node;
         this.row = row;
         this.col = col;
     }
 }
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(root, 0, 0));

        while(!q.isEmpty()){
            Pair pair = q.poll();
            int vertical = pair.row;
            int level = pair.col;
            TreeNode node = pair.node;

            if(!map.containsKey(vertical)){
                map.put(vertical, new TreeMap<>());
            }
            if(!map.get(vertical).containsKey(level)){
                map.get(vertical).put(level, new PriorityQueue<>());
            }

            map.get(vertical).get(level).offer(node.val);

            if(node.left != null) q.offer(new Pair(node.left, vertical -1 , level + 1));
            if(node.right != null) q.offer(new Pair(node.right, vertical + 1, level + 1));

        }

        for(TreeMap<Integer, PriorityQueue<Integer>> key : map.values()){
            list.add(new ArrayList<>());

            for(PriorityQueue<Integer> val : key.values()){
                while(!val.isEmpty()){
                    list.get(list.size() - 1).add(val.poll());
                }
            }
        }
        return list;
    }
}