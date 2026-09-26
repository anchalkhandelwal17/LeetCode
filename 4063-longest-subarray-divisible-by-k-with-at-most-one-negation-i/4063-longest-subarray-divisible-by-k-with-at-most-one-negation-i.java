class Solution {
    public int longestSubarray(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        for(int i=0; i<n; i++){
            HashSet<Integer> set = new HashSet<>();
            int sum = 0;
            for(int j=i; j<n; j++){
                sum = ((sum + nums[j]) % k + k) % k;
                set.add(((2 * nums[j]) % k + k) % k);

                if(sum == 0 || set.contains(sum)){
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        return ans;
    }
}