class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        
        int f = 0;
        int j=0;
        int i = 0;
        int ans1 = Integer.MIN_VALUE;
        while(j < answerKey.length()){
            if(answerKey.charAt(j) == 'F'){
                f++;
            }
            if(f > k){
                while(f > k){
                    if(answerKey.charAt(i) == 'F'){
                        f--;
                    }
                    i++;
                }
            }
            ans1 = Math.max(ans1, j-i+1);
            j++;
        }

        i = 0;
        j = 0;
        int ans2 = Integer.MIN_VALUE;
        int t = 0;
        while(j < answerKey.length()){
            if(answerKey.charAt(j) == 'T'){
                t++;
            }
            if(t > k){
                while(t > k){
                    if(answerKey.charAt(i) == 'T'){
                        t--;
                    }
                    i++;
                }
            }
            ans2 = Math.max(ans2, j-i+1);
            j++;
        }
        return Math.max(ans1, ans2);
    }
}