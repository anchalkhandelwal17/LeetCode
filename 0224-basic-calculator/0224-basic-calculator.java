class Solution {
    public int calculate(String s) {
        
        Stack<Integer> st = new Stack<>();
        int len = s.length();
        int sign = 1;
        int res = 0;

        for(int i=0; i<len; i++){
            if(Character.isDigit(s.charAt(i))){
                int sum = s.charAt(i) - '0';
                while(i + 1 < len && Character.isDigit(s.charAt(i + 1))){
                    sum = sum * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                res += sum * sign;
            }
            else if(s.charAt(i) == '+'){
                sign = 1;
            }
            else if(s.charAt(i) == '-'){
                sign = -1;
            }
            else if(s.charAt(i) == '('){
                st.push(res);
                st.push(sign);
                res = 0;
                sign = 1;
            }
            else if(s.charAt(i) == ')'){
                res = res * st.pop() + st.pop();
            }
        }
        return res;
    }
}