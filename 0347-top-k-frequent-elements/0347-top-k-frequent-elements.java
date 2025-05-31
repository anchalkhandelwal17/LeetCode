class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // TC : O(nlogk)
        // SC : O(n)
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        for(int key : map.keySet()){
            int V = map.get(key);
            int K = key;

            pq.offer(new int[]{V, K});
            if(pq.size() > k){
                pq.poll();
            }
        }

        int[] ans = new int[Math.min(k, pq.size())];
        int i = 0;
        while(!pq.isEmpty()){
            ans[i++] = pq.poll()[1];
        }
        return ans;
    }
}