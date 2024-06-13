class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        // TC : O(nlogn + nlogn + n)
        // SC : O(1)
        int n = seats.length;
        Arrays.sort(seats);
        Arrays.sort(students);

        int ans = 0;
        for(int i=0; i<n; i++){
            ans = ans + Math.abs(seats[i] - students[i]);
        }
        return ans;
    }
}

