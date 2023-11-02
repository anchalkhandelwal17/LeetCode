class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        
        HashMap<Integer, Integer> pref_sum = new HashMap<>();
        int sum = 0;
        int ans = 0;

        for(int i=0; i<nums.length; i++){
            sum += nums[i];

            if(pref_sum.containsKey(sum - goal)){
                ans += pref_sum.get(sum - goal);
            }
            if(sum == goal) ans++;

            pref_sum.put(sum, pref_sum.getOrDefault(sum, 0)+1);
        }
        return ans;
    }
}