class Solution {
    public int lengthOfLongestSubstring(String s) {
        // TC : O(n)
        // SC : O(n)
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int maxLen = 0;

        while(right < n){
            char c = s.charAt(right);

            if(map.containsKey(c)){
                left = Math.max(left, map.get(c) + 1);
            }
            maxLen = Math.max(maxLen, right - left + 1);
            map.put(c, right);
            right++;
        }
        return maxLen;
    }
}