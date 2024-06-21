class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        
        int n = customers.length;
        int i = 0, j = 0, max = 0, sum = 0, currSum = 0;
        for (int k = 0; k < n; k++) {
            sum += grumpy[k] != 1 ? customers[k] : 0;
        }

        while (j < n) {
            if(grumpy[j] == 1){
                currSum += customers[j];
            }

            if(j - i + 1 >= minutes){
                max = Math.max(max, currSum);
                if(grumpy[i] == 1){
                    currSum -= customers[i];
                }
                i++;
            }
            j++;
        }

        return sum + max;
    }
}
