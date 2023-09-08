class Solution {
    public int subarraySum(int[] nums, int k) {
        // TC : O(n), SC : O(n)
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        int currSum = 0;
        int ans = 0;
        map.put(0, 1);
        for(int i=0; i<n; i++){
            currSum += nums[i];

            int remove = (currSum - k);
            ans += map.getOrDefault(remove, 0);
            map.put(currSum, map.getOrDefault(currSum, 0)+1);
        }
        return ans;
    }
}