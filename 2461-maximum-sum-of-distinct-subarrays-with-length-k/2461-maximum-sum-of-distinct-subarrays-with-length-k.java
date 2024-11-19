class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        // TC : O(n)
        // SC : O(n)
        long ans = 0;
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int i=0;
        int j=0;
        long sum = 0;

        while(j < n){
            sum += nums[j];
            map.put(nums[j], map.getOrDefault(nums[j], 0)+1);
            if(j - i + 1 < k){
                j++;
            }
            else{
                if(map.size() == k){
                    ans = Math.max(ans, sum);
                    System.out.println(ans);
                }

                sum -= nums[i];
                map.put(nums[i], map.getOrDefault(nums[i], 0)-1);
                if(map.get(nums[i]) == 0) map.remove(nums[i]);
                i++;
                j++;
            }
        }
        return ans;
    }
}