class Solution {
    public long dividePlayers(int[] skill) {
        // TC : O(nlogn)
        // SC : O(1)
        Arrays.sort(skill);
        int n = skill.length;
        int totalTeams = n/2;
        long chemistry = 0;
        long sum = 0;

        // total sum of skills is calculated
        // now each each of size 2 should values with total = sum / totalTeams
        // if each team gets values with this sum / totalTeams
        // then good else return -1
        for(int x : skill) sum += x; 


        long totalSumEachTeam = sum / totalTeams;


        // make 2-2 pairs of n/2 teams with sum of every pair = totalSum / totalTeams
        // if any team fails to get this sum return -1 else calculate chemistry and 
        // return it

        int i=0, j=n-1;

        while(i < j){
            int a = skill[i];
            int b = skill[j];

            if(a + b != totalSumEachTeam) return -1;

            chemistry = chemistry + (a * b);
            i++;
            j--;
        }

        return chemistry;
    }
}