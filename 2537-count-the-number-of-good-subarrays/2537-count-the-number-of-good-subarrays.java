class Solution {
    public long countGood(int[] nums, int k) {
        
        long ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int i=0;
        int j=0;
        long cnt = 0;
        while(j < nums.length){
            cnt += map.getOrDefault(nums[j], 0);
            map.put(nums[j], map.getOrDefault(nums[j], 0)+1);
            while(cnt >= k){
                ans = ans + (nums.length-j);
                int temp = map.get(nums[i]);
                cnt -= temp-1;
                map.put(nums[i], map.get(nums[i]) - 1);
                
                if(map.get(nums[i]) == 0){
                    map.remove(nums[i]);
                }
                i++;
            }
            j++;
        }
        return ans;
    }
}