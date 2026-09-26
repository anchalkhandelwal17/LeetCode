class Solution {
    public int longestSubarray(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        for(int i=0; i<n; i++){
            HashSet<Integer> set = new HashSet<>();
            int rem = 0;
            for(int j=i; j<n; j++){
                rem = (rem + nums[j]) % k;
                if(rem < 0) rem += k;
                // set.add(((2 * nums[j]) % k + k) % k);

                int setVal = (2 * nums[j]) % k;
                if(setVal < 0) setVal += k;
                set.add(setVal);

                if(rem == 0 || set.contains(rem)){
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        return ans;
    }
}