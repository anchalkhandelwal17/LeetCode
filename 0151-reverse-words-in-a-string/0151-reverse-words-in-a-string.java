class Solution {
    public String reverseWords(String s) {
       // To split a string by space or multiple space between words, use split("\\s+")
       // to remove the leading and trailing space from string use trim()

       String[] str_split = s.trim().split("\\s+");

       StringBuilder ans = new StringBuilder();

       for(int i=str_split.length-1; i>=0; i--){
           ans.append(str_split[i]);
           if(i > 0){
               ans.append(" ");
           }
       }
       return ans.toString();
    }
}