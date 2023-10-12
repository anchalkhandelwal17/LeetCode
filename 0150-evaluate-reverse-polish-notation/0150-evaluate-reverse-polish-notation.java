class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<tokens.length; i++){
            int a;
            int b;
            if(tokens[i].equals("+")){
                a = st.pop();
                b = st.pop();
                st.push(b + a);
            }
            else if(tokens[i].equals("-")){
                a = st.pop();
                b = st.pop();
                st.push(b - a);
            }
            else if(tokens[i].equals("*")){
                a = st.pop();
                b = st.pop();
                st.push(b * a);
            }
            else if(tokens[i].equals("/")){
                a = st.pop();
                b = st.pop();
                st.push(b / a);
            }
            else{
                 st.push(Integer.parseInt(tokens[i]));
            }
        }
        return st.pop();      
    }
}