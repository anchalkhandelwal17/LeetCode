class Solution {
    public String removeKdigits(String num, int k) {
        // TC : O(n)
        // SC : O(n)
        int n = num.length();
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++){
            int val = num.charAt(i) - '0';
            while(k > 0 && !st.isEmpty() && st.peek() > val){
                k--;
                st.pop();
            }
            st.push(val);
        }

        // if k is still > 0 remove vals from stack;
        while(k > 0 && !st.isEmpty()){
            st.pop();
            k--;
        }

        // ans creation
        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty()){
            ans.append(st.pop());
        }

        // removing all the leading zeroes
        for(int i=ans.length()-1; i>=0; i--){
            if(ans.charAt(i) == '0'){
                ans.deleteCharAt(i);
            }
            else break;
        }
        return ans.length() == 0 ? "0" : ans.reverse().toString();
    }
}