class Solution {
    public long maxKelements(int[] nums, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long ans = 0;
        for(int val : nums){
            pq.offer(val);
        }
        for(int i=0; i<k; i++){
            double temp = pq.poll();
            ans += temp;
            temp = (double)(temp/3);
            pq.offer((int)(Math.ceil(temp)));
        }
        return ans;
        
    }
}