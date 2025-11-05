class Solution {
    public long maxProduct(int[] nums) {
        int zeroes = 0;
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<n; i++){
            if(nums[i] == 0) zeroes++;
            pq.offer(Math.abs(nums[i]));

            if(pq.size() > 2) pq.poll();
        }

        if(zeroes >= n-1) return 0;
        int a = pq.poll();
        int b = pq.poll();
        long c = 100000;
        long d = -100000;

        return (1l * a * b) * c;
    }
}