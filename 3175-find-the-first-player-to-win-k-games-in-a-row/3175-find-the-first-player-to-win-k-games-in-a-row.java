class Solution {
    public int findWinningPlayer(int[] skills, int k) {
        
        int n = skills.length;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            q.offer(i);
        }
//         int max = -1;
        int[] temp = new int[n];
   //      int a = q.poll();
//         int b = q.poll();
//         max = Math.max(skills[a], skills[b]);
//         if(a > b){
//             temp[a]++;
//             if(temp[a] >= k){
//                 return a;
//             }
//             q.offer(b);
//         }
//         else{
//             System.out.println(max);
//             temp[b]++;
//             if(temp[b] >= k){
//                 return b;
//             }
//             q.offer(a);
//         }
        int ans = 0;
        for(int i=1; i<n; i++){
            if(skills[i] > skills[ans]){
                ans = i;
            }
        }
        int i = 0;
        int max = q.poll();
        System.out.println(max);
        while(!q.isEmpty()){
            int a = q.poll();
            
            if(skills[a] > skills[max]){
                max = a;
                temp[max] = 0;
                temp[a]++;
                if(temp[a] >= k){
                    return a;
                }
                System.out.println(max);
                q.offer(max);
            }
            else{
                temp[a] = 0;
                temp[max]++;
                if(temp[max] >= k){
                    return max;
                }
                q.offer(a);
            }
            i++;
            if(i >= n){
                return ans;
            }
        }
        return ans;
    }
}