class Solution {
    public String removeKdigits(String num, int k) {
        // TC : O(n)
        // SC : O(n)
        int n = num.length();
        Stack<Integer> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            int value = num.charAt(i) - '0';

            while(!st.isEmpty() && k > 0 && st.peek() > value){
                st.pop();
                k--;
            }
            st.push(value);
        }

        while(!st.isEmpty() && k > 0){
            st.pop();
            k--;
        }

        while(!st.isEmpty()){
            sb.append(st.pop());
        }

        for(int i=sb.length()-1; i>=0; i--){
            if(sb.charAt(i) == '0'){
               sb.deleteCharAt(i);
            }
            else break;
        }

        return sb.length() == 0 ? "0" : sb.reverse().toString();
    }
}