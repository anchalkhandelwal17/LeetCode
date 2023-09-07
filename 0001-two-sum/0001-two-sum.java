class Solution {
    public int[] twoSum(int[] nums, int target) {
        // TC : O(n), SC : O(n)
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i=0; i<n; i++){
            int val = target - nums[i];
            if(map.containsKey(val)){
                return new int[]{map.get(val), i};
            }
            else{
                map.put(nums[i], i);
            }
        }   
        return new int[]{-1,-1};
    }
}