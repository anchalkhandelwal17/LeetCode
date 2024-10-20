class Solution {
    public int longestSubsequence(int[] arr, int diff) {
        // TC : O(n)
        // SC : O(n)
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 1;
        for(int num : arr){
            map.put(num, map.getOrDefault(num - diff, 0)+1);

            ans = Math.max(ans, map.get(num));
        }
        return ans;
    }
}