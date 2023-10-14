class Solution {
    public int calculate(String s) {

        Stack<Integer> st = new Stack<>();
        Character operator = '+';
        int n = s.length();

        for(int i=0; i<n; i++){
            char c = s.charAt(i);

            if(Character.isDigit(c)){
                int num = 0;
                while(i < n && Character.isDigit(s.charAt(i))){
                    num = (num * 10 ) + (s.charAt(i) - '0');
                    i++; 
                }
                i--;
                if(operator == '+'){
                    st.push(num);
                }
                else if(operator == '-'){
                    st.push(-num);
                }
                else if(operator == '*'){
                    int val = st.pop();
                    st.push(val * num);
                }
                else if(operator == '/'){
                    int val = st.pop();
                    st.push(val / num);
                }
            }
            else if(c != ' '){
                operator = s.charAt(i);
            }
        }   
    int sum = 0;
    while(!st.isEmpty()) sum += st.pop();

    return sum;
}
}