class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        for (int key : map.keySet()) {
            int K = key;
            int V = map.get(K);

            pq.offer(new int[] { K, V });
            if (pq.size() > k)
                pq.poll();
        }

        int[] ans = new int[pq.size()];
        int idx = 0;

        while (!pq.isEmpty()) {
            int[] arr = pq.poll();
            int K = arr[0];
           
            ans[idx++] = K;

        }

        return ans;
    }
}