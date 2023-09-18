class Pair{
    int key;
    int val;
    public Pair(int key, int val){
        this.key = key;
        this.val = val;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) ->{
            return a.val - b.val;
        });
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int val : nums){
            map.put(val, map.getOrDefault(val, 0)+1);
        }
        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            pq.add(new Pair(e.getKey(),e.getValue()));
            if(pq.size() > k){
                pq.poll();
            }
        }
        int[] ans = new int[k];
        while(!pq.isEmpty()){
            ans[--k] = pq.peek().key;
            pq.poll();
        }
        return ans;
    }
}