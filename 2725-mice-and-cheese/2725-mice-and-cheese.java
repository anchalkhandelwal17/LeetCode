class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        // TC : O(nlogk)
        // SC : O((k * 2) + k)
        int n = reward1.length;
        int ans = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        for(int i=0; i<n; i++){
            int val = reward1[i] - reward2[i];

            pq.offer(new int[]{i, val});

            if(pq.size() > k) pq.poll();
        }

        HashSet<Integer> set = new HashSet<>();

        while(!pq.isEmpty()){
            int[] arr = pq.poll();
            set.add(arr[0]);
            ans += reward1[arr[0]];
        }

        if(set.size() == n) return ans;

        for(int i=0; i<n; i++){
            if(set.contains(i)) continue;

            ans += reward2[i];
        }

        return ans;

    }
}