class Solution {
    public String largestGoodInteger(String num) {
        
        String[] str = {"999", "888", "777", "666", "555", "444", "333", "222", "111", "000"};
        
        int i = 0;
        
        // while(i < num.length() && num.charAt(i) - '0' == 0) i++;
        // num = num.substring(i);
        
        while(i < str.length){
            if(num.contains(str[i])) return str[i];
            i++;
        }
        
        return "";
        
    }
}