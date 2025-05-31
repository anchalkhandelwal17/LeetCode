class Solution {
    public int evalRPN(String[] tokens) {
        // TC : O(n)
        // SC : O(n)
        int n = tokens.length;
        Stack<Integer> st = new Stack<>();
        int[] arr;
        for(int i=0; i<n; i++){
            String str = tokens[i];

            if(str.equals("+")){
                arr = topTwoVal(st);
                st.push(arr[1] + arr[0]);
            }
            else if(str.equals("-")){
                arr = topTwoVal(st);
                st.push(arr[1] - arr[0]);
            }
            else if(str.equals("/")){
                arr = topTwoVal(st);
                st.push(arr[1] / arr[0]);
            }
            else if(str.equals("*")){
                arr = topTwoVal(st);
                st.push(arr[1] * arr[0]);
            }
            else st.push(Integer.valueOf(str));
        }
        return st.pop();
    }

    public int[] topTwoVal(Stack<Integer> st){
        int a = st.pop();
        int b = st.pop();

        return new int[]{a, b};
    }
}