class Solution {
    public String clearDigits(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length();
        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                if(!st.isEmpty()){
                    st.pop();
                }
            }
            else st.push(c);
        }
        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty()){
            ans.append(st.pop());
        }
        return ans.reverse().toString();
    }
}