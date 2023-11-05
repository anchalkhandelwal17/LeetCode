class Solution {
    public int getWinner(int[] arr, int k) {
        
        int winner = Math.max(arr[0], arr[1]);
        if(k == 1) return winner;

        int win_count = 1;

        for(int i=2; i<arr.length; i++){
            if(winner > arr[i]){
                win_count++;
            }
            else if(arr[i] > winner){
                winner = arr[i];
                win_count = 1;
            }

            if(win_count == k){
                return winner;
            }
        }
        return winner;
    }
}