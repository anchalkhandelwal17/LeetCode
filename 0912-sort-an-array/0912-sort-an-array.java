class Solution {
    public int[] sortArray(int[] nums) {
        // TC : O(nlogn)
        // SC : O(n)
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int x : nums) pq.offer(x);
        int i=0;
        while(!pq.isEmpty()){
            nums[i++] = pq.poll();
        }
        return nums;
    }
}