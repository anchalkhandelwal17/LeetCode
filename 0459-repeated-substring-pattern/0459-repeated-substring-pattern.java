class Solution {
    public boolean repeatedSubstringPattern(String s) {

        int len = s.length();

        for(int i=len/2; i>=1; i--){
            if(len % i == 0){

                int total_append = len/i;
                String str = s.substring(0, i);
                StringBuilder sb = new StringBuilder();
                for(int append=0; append<total_append; append++){
                    sb.append(str);
                }
                if(sb.toString().equals(s)) return true;
            }
        }
        return false;
    }
}