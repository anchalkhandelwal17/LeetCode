class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();

            pq.offer(new int[] { key, val });
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] ans = new int[Math.min(k, pq.size())];
        int i = ans.length - 1;
        while (!pq.isEmpty()) {
            ans[i--] = pq.poll()[0];
        }
        return ans;
    }
}

// [1,2,1,2,1,2,3,1,3,2], k = 2
// 1 -> 4, 2 -> 4, 3 -> 2
// [1, 4], [2, 4], [3, 2] map
// pq -> {1, 4}{2,4}{3,2} top k = [1, 2]
// treemap also can be used
