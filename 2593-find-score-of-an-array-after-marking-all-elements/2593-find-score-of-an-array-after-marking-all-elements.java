class Solution {
    public long findScore(int[] nums) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b ) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        
        for(int i=0; i<n; i++){
            pq.offer(new int[]{nums[i], i});
        }

        long score = 0;
        while(!pq.isEmpty()){
            int val = pq.peek()[0];
            int idx = pq.peek()[1];
            pq.poll();
            if(nums[idx] == -1){
                continue;
            }
            else{
                score += val;
                nums[idx] = -1;
                if(idx-1 >= 0){
                    nums[idx-1] = -1;
                }
                if(idx+1 < n){
                    nums[idx+1] = -1;
                }
            }
        }
        return score;
    }
}