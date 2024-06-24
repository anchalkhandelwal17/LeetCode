class Solution {
    public int minKBitFlips(int[] nums, int k) {
        // TC : O(n)
        // SC : O(n)
        int n = nums.length;
        Queue<Integer> q = new LinkedList<>();
        int ans = 0;
        for(int i=0; i<n; i++){
            if(!q.isEmpty() && (i - q.peek() >= k)){
                q.poll();
            }

            if((nums[i] == 0 && q.size()%2==0) || (nums[i] == 1 && q.size()%2 == 1)){
                if(i + k > n) return -1;
                ans++;
                q.offer(i);
            }
        }
        return ans;
    }
}