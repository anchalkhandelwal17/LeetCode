class Solution {
    public boolean isSubsequence(String s, String t) {
        int cnt = 0;
        int tLen = t.length();

        for(int i=0; i<tLen && cnt<s.length(); i++){
            char c = t.charAt(i);
            if(c == s.charAt(cnt)){
                cnt++;
            }
        }
        if(cnt == s.length()) return true;
        return false;
    }
}