class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        // TC : O(n^2)
        // SC : O(n)
        if((hand.length % groupSize ) != 0) return false;

        int totalGroups = hand.length/groupSize;
        Arrays.sort(hand);
        int n = hand.length;
        int[] arr = new int[n];
        for(int i=0; i<n; i+=groupSize){
            int cnt = 0;
            int prev = -1;
            for(int j=0; j<n; j++){
                if(arr[j] == 0 && prev == -1){
                    prev = hand[j];
                    cnt++;
                    arr[j] = -1;
                }
                else if(arr[j] == 0 && prev != -1 && hand[j] - prev == 1){
                    arr[j] = -1;
                    prev = hand[j];
                    cnt++;
                }
                if(cnt == groupSize){
                    break;
                }
            }
            if(cnt != groupSize){
                return false;
            }
        }
        return true;
    }
}