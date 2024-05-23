class Solution {
    public long beautifulSubarrays(int[] nums) {
        // TC : O(n)
        // SC : O(n)
        int n = nums.length;
        long ans = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] pref = new int[n];
        map.put(0, 1);
        for (int i = 0; i < n; i++) {
            if(i == 0) pref[i] = nums[i];
            else pref[i] = pref[i - 1] ^ nums[i];
            if (map.containsKey(pref[i])) {
                ans = ans + map.get(pref[i]);
            }
            map.put(pref[i], map.getOrDefault(pref[i], 0) + 1);
        }
        return ans;
    }
}