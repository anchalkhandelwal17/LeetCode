class Solution {
    public int numberOfSpecialChars(String word) {
        
        HashSet<Character> set = new HashSet<>();
        for(int i=0; i<word.length(); i++){
            set.add(word.charAt(i));
        }
        int cnt = 0;
        for(char c = 'a'; c<='z'; c++){
            if(set.contains(c) && set.contains(Character.toUpperCase(c))){
                cnt++;
            }
            
        }
        return cnt;
    }
}