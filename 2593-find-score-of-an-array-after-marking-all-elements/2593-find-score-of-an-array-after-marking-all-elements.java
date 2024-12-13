class Solution {
    public long findScore(int[] nums) {
        // TC : O(nlogn)
        // SC : O(n)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if(a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        int n = nums.length;

        for(int i=0; i<n; i++){
            pq.offer(new int[]{nums[i], i});
        }

        long score = 0;
        while(pq.size() > 0){
            int num = pq.peek()[0];
            int idx = pq.peek()[1];
            pq.poll();
            if(nums[idx] == -1) continue;
            else{
                score += num;
                nums[idx] = -1;

                if(idx-1 >= 0) nums[idx-1] = -1;
                if(idx+1 < n) nums[idx+1] = -1; 
            }
        }
        return score;

    }
}

// two ds coming to mind is map and pq
