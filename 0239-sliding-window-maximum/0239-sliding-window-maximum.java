class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Deque<int[]> dq = new ArrayDeque<>();

        for(int i=0; i<n; i++){

            while(!dq.isEmpty() && dq.getLast()[1] <= nums[i]){
                dq.removeLast();
            }

            if(!dq.isEmpty() && dq.peek()[0] < i-k+1){
                dq.remove();
            }

            dq.addLast(new int[]{i, nums[i]});

            if(i - k + 1 >= 0){
                ans[i - k + 1] = dq.getFirst()[1];
            }
        }
        return ans;
    }
}
