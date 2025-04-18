class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            int val = nums[i];
            if(map.containsKey(target - val)){
                return new int[]{map.get(target - val), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}