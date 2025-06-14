class Solution {
    public String removeKdigits(String num, int k) {
        // TC : O(n)
        // SC : O(n)
        int n = num.length();
        Stack<Integer> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++){
            int val = Character.getNumericValue(num.charAt(i)); 

            while(!st.isEmpty() && st.peek() > val && k > 0){
                st.pop();
                k--;
            }
            st.push(val);
        }

        while(k > 0 && !st.isEmpty()){
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


// 1432219, k = 3       // 1219 // 9121

// while(st.peek() >= num(i)) remove and k--
// then push(num(i))

// while(k > 0) st.remove() and k--
// while(!stempty) sb.sppend()
// 

// [1, 2, 1, 9]

// [2, 0, 0]

// [0]