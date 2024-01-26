class Solution {
    public boolean makeStringsEqual(String s, String target) {
        if(s.equals(target)) return true;
        
        int ones = 0;
        int zeroes = 0;
        int ones2 = 0;
        int zeroes2 = 0;
        int n = s.length();
        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            if(c - 48 == 0) zeroes++;
            else ones++;
        }
        for(int i=0; i<n; i++){
            char c = target.charAt(i);
            if(c - 48 == 0) zeroes2++;
            else ones2++;
        }
        return (((ones > 0 && zeroes > 0) || ones == n) && ((ones2 > 0 && zeroes2 > 0) || (ones2 == n)));
    }
}