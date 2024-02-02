class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
       List<Integer> list = new ArrayList<>();
        String s = "123456789";
        while(low <= high){
            int num = low;
            int cnt = 0;
            while(num != 0){
                cnt++;
                num /= 10;
            }
            int i = 0;
            int j = cnt;
            while(j <= s.length()){
                int val = Integer.parseInt(s.substring(i,j));
                if(val >= low && val <= high){
                    list.add(val);
                }
                i++;
                j++;
            }
            low = (int)(Math.pow(10, cnt));
        }
        return list;
    }
    
    // public boolean checkVal(int num){
    //     int prevVal = num%10;
    //     num /= 10;
    //     while(num != 0){
    //         int currVal = num%10;
    //         if(prevVal - currVal != 1){
    //             return false;
    //         }
    //         prevVal = currVal;
    //         num/=10;
    //     }
    //     return true;
    // }
}