class Solution {
    public int myAtoi(String s) {
        if(s == null) return 0;

        int i = 0;
        while(i< s.length() && s.charAt(i) == ' '){
            i++;
        }
        s = s.substring(i);
        if(s.length() == 0) return 0;

        long val = 0;
        int sign = 1;
        if(s.charAt(0) == '-'){
            sign = -1;
        }

        if(s.charAt(0) == '+' || s.charAt(0) == '-'){
            i = 1;
        }
        else{
            i = 0;
        }

        while(i < s.length()){
            if(!isdigit(s.charAt(i))){
                break;
            }
            val = val * 10 + s.charAt(i) - '0';        
                     
            if(sign == -1 && -1*val < Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
            if(sign == 1 && val > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            i++;
        }

        return (int)val*sign;  
    }

    public boolean isdigit(char val){
        return val >= 48 && val <= 57;
    }
}