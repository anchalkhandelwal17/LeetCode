class Solution {
    public boolean doesAliceWin(String s) {
        // TC : O(n)
        // SC : O(1)
        int n = s.length();
        boolean ans = true;
        int cnt = 0;
        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            if(isVowel(c)){
                cnt++;
            }
        }
        if(cnt == 0) return false;
        else if(cnt % 2 == 1) return true;
        return true;
    }
    public boolean isVowel(char c ){
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
            return true;
        }
        return false;
    }
}