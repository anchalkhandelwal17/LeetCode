class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);

            if(ch == '(' || ch == '{' || ch == '['){
                st.push(ch);
            }
            else if(ch == ')' && !st.isEmpty() && st.peek() == '('){
                st.pop();
            }
            else if(ch == '}' && !st.isEmpty() && st.peek() == '{'){
                st.pop();
            }
            else if(ch == ']' && !st.isEmpty() && st.peek() == '['){
                st.pop();
            }
            else return false;
        }
        return st.isEmpty();
    }
}