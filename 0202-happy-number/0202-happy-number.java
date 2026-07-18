class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();

        while(true){
            if(n == 1) break;

            int temp = n;
            int sum = 0;
            while(temp != 0){
                int rem = temp % 10;
                sum = sum + (rem * rem);
                temp /= 10;
            }
            if(set.contains(sum)){
                return false;
            }
            else set.add(sum);
            n = sum;
        }
        return true;
    }
}