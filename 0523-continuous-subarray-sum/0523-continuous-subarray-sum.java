class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        // TC : O(n)
        // SC : O(n)
        int n = nums.length;
        int sum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0, -1);
        for(int i=0; i<n; i++){
            sum += nums[i];
            sum %= k;
            if(map.containsKey(sum)){
                if( i - map.get(sum) > 1) return true;
            }
            else map.put(sum, i);
        }
        return false;
    }
}