class Solution {
    public long continuousSubarrays(int[] nums) {
        // TC : O(nlogn)
        // SC : O(n)
        int i=0, j=0, n=nums.length;
        long ans = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();

        while(j < n){
            map.put(nums[j], map.getOrDefault(nums[j], 0)+1);
            while(!map.isEmpty() && map.lastKey() - map.firstKey() > 2){
                map.put(nums[i], map.getOrDefault(nums[i], 0)-1);
                if(map.get(nums[i]) == 0) map.remove(nums[i]);
                i++;
            }
            ans = ans + (j - i + 1);
            j++;
        }
        return ans;
    }
}
