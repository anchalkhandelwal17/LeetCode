class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int ans = 0;
        int i = 0;
        int j = people.length-1;

        while(i <= j){
            if(i < j && people[i] + people[j] > limit){
                ans++;
                j--;
            }
            else{
                i++;
                j--;
                ans++;
            }
        
        }
        return ans;
    }
}