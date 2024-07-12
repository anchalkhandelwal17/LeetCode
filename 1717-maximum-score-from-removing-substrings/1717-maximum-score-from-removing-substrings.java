class Solution {
    public int maximumGain(String s, int x, int y) {
        // TC : O(n)
        // SC : O(n)
        int ans = 0;
        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();

        int maxVal = Math.max(x, y);
        int minVal = Math.min(x, y);
        char fir = (x > y) ? 'a' : 'b';
        char sec = (x > y) ? 'b' : 'a';

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(!st1.isEmpty() && ch == sec && st1.peek() == fir){
                ans += maxVal;
                st1.pop();
            }
            else st1.push(ch);
        }
        while(!st1.isEmpty()){
            char ch = st1.pop();
            if(!st2.isEmpty() && ch == sec && st2.peek() == fir){
                ans += minVal;
                st2.pop();
            }
            else st2.push(ch);
        }
        return ans;
    }
}

