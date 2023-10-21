class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        Arrays.sort(strs);

        String st1 = strs[0];
        String st2 = strs[strs.length-1];
        int index = 0;

        while(index < st1.length() && index < st2.length()){
            if(st1.charAt(index) == st2.charAt(index)){
                index++;
            }
            else{
                break;
            }
        }

        return st1.substring(0, index);
    }
}