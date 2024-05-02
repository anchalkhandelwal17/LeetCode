class Solution {
    public int findMaxK(int[] nums) {
        // TC : O(n)
        // SC : O(n)
        HashSet<Integer> neg = new HashSet<>();

        for(int x : nums){
            if(x < 0){
                neg.add(x);
            }
        }

        int ans = -1;

        for(int x : nums){
            if(x > 0 && neg.contains(-x) && x > ans){
                ans = x;
            }
        }
        return ans;
    }
}