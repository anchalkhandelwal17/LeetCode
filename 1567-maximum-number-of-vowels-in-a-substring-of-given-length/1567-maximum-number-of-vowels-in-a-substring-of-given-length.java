class Solution {
    public int maxVowels(String s, int k) {
        if(k > s.length() ) return 0;

        int i = 0;
        int j = 0;
        int ans = Integer.MIN_VALUE;
        int no_of_vowels = 0;
        while(j < s.length()){
            if(isVowel(s.charAt(j))){
                no_of_vowels++;
            }
            if(j-i+1 < k){
                j++;
            }
            else if(j -i+1 == k){
                ans = Math.max(ans, no_of_vowels);
                if(isVowel(s.charAt(i))){
                    no_of_vowels--;
                }
                i++;
                j++;
            }
        }
        return ans;
    }

    public boolean isVowel(char c){
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
            return true;
        }
        return false;
    }
}