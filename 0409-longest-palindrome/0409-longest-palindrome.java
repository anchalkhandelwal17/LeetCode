class Solution {
    public int longestPalindrome(String s) {
        // TC : O(n)
        // SC : O(n)
        int n = s.length();
        int ans = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        boolean flag = false;
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        for(char c : map.keySet()){
            int val = map.get(c);
            if(val % 2 == 0){
                ans += val;
            }
            else{
                if(flag == false){
                    flag = true;
                    ans += val;
                }
                else if(val > 1){
                    ans += val - 1;
                }
            }
        }
        return ans;
    }
}