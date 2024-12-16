class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        // TC : O(nlogn)
        // SC : O(n)
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if(a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        // for(int x : nums) pq.offer(x);
        for(int i=0; i<n; i++){
            pq.offer(new int[]{nums[i], i});
        }
        while(k > 0){
            // int x = pq.poll();
            // pq.offer(x * multiplier);
            int[] curr = pq.poll();
            int x = curr[0];
            pq.offer(new int[]{x * multiplier, curr[1]});
            k--;
        }
        while(!pq.isEmpty()){
            nums[pq.peek()[1]] = pq.peek()[0];
            pq.poll();
        }
        return nums;
    }
}