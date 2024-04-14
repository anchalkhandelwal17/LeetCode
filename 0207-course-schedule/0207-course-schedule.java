class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int n = numCourses;
        for(int i=0; i<n; i++){
            list.add(new ArrayList<>());
        }

        for(int i=0; i<prerequisites.length; i++){
            list.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        // calculating indegree of all the nodes
        int[] inDegree = new int[n];
        for(int i=0; i<n; i++){
            for(int it : list.get(i)){
                inDegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        int cnt = 0;
        for(int i=0; i<n; i++){
            if(inDegree[i] == 0){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            cnt++;
            int node = q.poll();
            for(int it : list.get(node)){
                inDegree[it]--;
                if(inDegree[it] == 0){
                    q.offer(it);
                }
            }
        }
        return cnt == numCourses;
    }
}