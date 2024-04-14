class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        int n = numCourses;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            list.add(new ArrayList<>());
        }
        for(int i=0; i<prerequisites.length; i++){
            list.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int[] inDegree = new int[n];
        for(int i=0; i<n; i++){
            for(int it : list.get(i)){
                inDegree[it]++;
            }
        }
        int idx = 0;
        int cnt = 0;
        int[] ans = new int[n];
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(inDegree[i] == 0){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            cnt++;
            int node = q.poll();
            ans[idx++] = node;

            for(int it : list.get(node)){
                inDegree[it]--;
                if(inDegree[it] == 0){
                    q.offer(it);
                }
            }
        }
        if(cnt == n) return ans;
        return new int[]{ };
    }
}