class Solution {
    public int subarraySum(int[] nums, int k) {
        // TC : O(n)
        // SC : O(n)
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0, 1);
        int ans = 0, sum = 0;
        for(int i=0; i<n; i++){
            sum += nums[i];
            ans += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum , 0)+1);
        }
        return ans;
    }
}