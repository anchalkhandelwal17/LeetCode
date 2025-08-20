class Solution {
    public int longestConsecutive(int[] nums) {
        // TC : O(n)
        // SC : O(n)
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        int max = 0;
        for(int x : nums) set.add(x);

        for(int x : set){
            int val = x;
            int cnt = 1;
            if(!set.contains(x-1)){
                while(set.contains(val + 1)){
                    val++;
                    cnt++;
                }
                max = Math.max(cnt, max);
            }
        }
        return max;
    }
}