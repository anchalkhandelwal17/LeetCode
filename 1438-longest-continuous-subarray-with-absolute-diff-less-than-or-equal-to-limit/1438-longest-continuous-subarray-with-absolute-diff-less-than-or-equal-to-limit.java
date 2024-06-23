class Solution {
    public int longestSubarray(int[] nums, int limit) {
        // TC : O(nlogn)
        // SC : O(n)
        int i=0;
        int j=0;
        int ans=0;
        int n = nums.length;
        TreeMap<Integer,Integer> map = new TreeMap<>();

        while(j < n){
            map.put(nums[j], map.getOrDefault(nums[j], 0)+1);

            while(map.lastKey() - map.firstKey() > limit){
                
                map.put(nums[i], map.getOrDefault(nums[i], 0)-1);

                if(map.get(nums[i]) == 0){
                    map.remove(nums[i]);
                }
                ++i;
            }

            ans = Math.max(ans, j-i+1);
            j++;
        }
        return ans;
    }
}