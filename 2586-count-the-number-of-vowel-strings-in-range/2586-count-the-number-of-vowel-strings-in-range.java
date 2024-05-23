class Solution {
    public int vowelStrings(String[] words, int left, int right) {
        // TC : O(n)
        // SC : O(1)
        int ans = 0;
        while(left <= right){
            String str = words[left];
            if(isVowel(str.charAt(0)) && isVowel(str.charAt(str.length()-1))){
                ans++;
            }
            left++;
        }
        return ans;
    }
    
    public boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}