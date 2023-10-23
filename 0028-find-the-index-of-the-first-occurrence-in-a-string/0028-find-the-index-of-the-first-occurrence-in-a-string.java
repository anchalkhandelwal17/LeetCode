class Solution {
    public int strStr(String haystack, String needle) {
        
        int a = haystack.length();
        int b = needle.length();
        if(b == 0) return 0;
        else if(a == 0) return -1;
        
        for(int i=0; i<a; i++){
            if(i + b > a) return -1;

            for(int j=0; j<b; j++){
                if(haystack.charAt(i+j) != needle.charAt(j)){
                    break;
                }
                if(j == needle.length()-1){
                    return i;
                }
            }
        }
        return -1;
    }
}