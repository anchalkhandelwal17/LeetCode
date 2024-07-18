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
        // TC : O(nlogn)
        // SC : O(n)
        List<List<Integer>> ans = new ArrayList<>();
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0, 0));

        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0; i<size; i++){
                Pair p = q.poll();
                TreeNode curr = p.node;
                int r = p.row;
                int c = p.col;

                if(!map.containsKey(c)){
                    map.put(c, new TreeMap<>());
                }
                if(!map.get(c).containsKey(r)){
                    map.get(c).put(r, new PriorityQueue<>());
                }

                map.get(c).get(r).add(curr.val);
                if(curr.left != null){
                    q.offer(new Pair(curr.left, r+1, c-1));
                }

                if(curr.right != null){
                    q.offer(new Pair(curr.right, r+1, c+1));
                }
            }
        }

        for(int key : map.keySet()){
            List<Integer> list = new ArrayList<>();
            for(int val : map.get(key).keySet()){
                while(map.get(key).get(val).size() > 0){
                    list.add(map.get(key).get(val).poll());
                }
            }
            ans.add(new ArrayList<>(list));
        }
        return ans;
    }
}