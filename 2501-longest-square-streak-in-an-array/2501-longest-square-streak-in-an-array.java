class Solution {
    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0;
        HashSet<Long> set = new HashSet<>();
        for(int x : nums) set.add(1l * x);

        for(int i=2; i<=1000; i++){
            long val = i;
            int currMax = 0;
            for(int j=0; j<=18; j++){
                if(set.contains(val)){
                    currMax++;
                    val *= val;
                }
            }
            ans = Math.max(ans, currMax);
        }
        if(ans == 1 || ans == 0) return -1;
        return ans;
    }
}