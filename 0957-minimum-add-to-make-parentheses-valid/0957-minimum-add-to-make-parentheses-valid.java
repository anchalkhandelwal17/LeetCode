class Solution {
    public int minAddToMakeValid(String s) {
        // TC : O(n)
        // SC : O(n)
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == ')' && !st.isEmpty() && st.peek() == '('){
                st.pop();
            }
            else st.push(c);
        }
        return st.size();
    }
}