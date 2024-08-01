class Solution {
    public int countSeniors(String[] details) {
        int cnt = 0;
        int n = details.length;
        for(int i=0; i<n; i++){
            String s = details[i];
            int a = s.charAt(s.length()-4) - '0';
            int b = s.charAt(s.length()-3) - '0';
            a = a * 10 + b;
            if(a > 60) cnt++;
        }
        return cnt;
    }
}