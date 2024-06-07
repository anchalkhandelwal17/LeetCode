class Solution {
    public int maximizeGreatness(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int x : nums) pq.offer(x);
        int cnt = 0;
        while(!pq.isEmpty()){
            int val = pq.poll();
            if(val > nums[i]){
                i++;
                cnt++;
            }
        }
        return cnt;
    }
}