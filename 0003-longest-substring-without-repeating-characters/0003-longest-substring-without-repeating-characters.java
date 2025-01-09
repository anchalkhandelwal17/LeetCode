class Solution {
    public int lengthOfLongestSubstring(String s) {
        // TC : O(n)
        // SC : O(n)

        int n = s.length();
        int i=0;
        int j=0;
        HashMap<Character, Integer> map = new HashMap<>();
        int ans = Integer.MIN_VALUE;

        while(j < n){
            char c = s.charAt(j);

            if(map.containsKey(c)){
                i = Math.max(i, map.get(c) + 1);
            }

            ans = Math.max(ans, j - i + 1);
            map.put(c, j);
            j++;
        }
        return ans == Integer.MIN_VALUE ? 0 : ans;
    }
}

// sliding window can be used along with hashmap