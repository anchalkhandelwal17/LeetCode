class Solution {
    public String reverseWords(String s) {
        
        s = s.trim();
        String[] str = s.split("\\s+");
        // System.out.println(Arrays.toString(str));

        StringBuilder ans = new StringBuilder();
        int n = str.length;

        for(int i=n-1; i>=0; i--){
            String curr = str[i];

            ans.append(curr);
            if(i != 0) ans.append(" ");
        }
        return ans.toString();
    }
}