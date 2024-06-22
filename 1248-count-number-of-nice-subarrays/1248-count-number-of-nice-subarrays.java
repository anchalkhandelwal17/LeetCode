class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        HashMap<Integer, Integer> pref_sum = new HashMap<>();

        int nice = 0;
        int ans = 0;

        for(int i=0; i<nums.length; i++){

            if(nums[i] % 2 == 1){
                nice++;
            }

            if(pref_sum.containsKey(nice-k)){
                ans += pref_sum.get(nice - k);
            }

            if(nice == k){
                ans++;
            }

            pref_sum.put(nice, pref_sum.getOrDefault(nice, 0)+1);
        }
        return ans;
    }
}