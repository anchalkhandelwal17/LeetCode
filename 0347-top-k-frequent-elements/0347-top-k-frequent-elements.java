class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // TC : O(nlogk)
        // Sc : O(n)
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        for(int key : map.keySet()){
            int K = key;
            int V = map.get(K);

            minHeap.offer(new int[]{V, K});
            if(minHeap.size() > k) minHeap.poll();
        }

        int[] ans = new int[Math.min(k, minHeap.size())];
        int idx = 0;
        while(!minHeap.isEmpty()){
            ans[idx++] = minHeap.poll()[1];
        }
        return ans;
    }
}