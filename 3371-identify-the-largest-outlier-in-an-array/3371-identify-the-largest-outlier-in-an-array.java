class Solution {
    public int getLargestOutlier(int[] nums) {
        // TC : O(n)
        // SC : O(n)
        HashMap<Integer, Integer> map = new HashMap<>();
        long totalSum = 0;
        for(int i=0; i<nums.length; i++){
            totalSum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        int outlier = Integer.MIN_VALUE;
        for(int num : nums){
            long currSum = totalSum - num;

            if(currSum % 2 != 0) continue;
            map.put(num, map.getOrDefault(num, 0)-1);

            int potentialSum = (int)(currSum / 2);

            if(map.getOrDefault(potentialSum, 0) > 0){
                outlier = Math.max(outlier, num);
            }
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        return outlier;
    }
}