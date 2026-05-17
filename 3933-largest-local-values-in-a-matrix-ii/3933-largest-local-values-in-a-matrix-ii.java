class Solution {
    public int countLocalMaximums(int[][] matrix) {
        // TC : O()
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = 0;

        ArrayList<int[]>[] list = new ArrayList[201];
        for(int i=0; i<=200; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                list[matrix[i][j]].add(new int[]{i, j});
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){

                int x = matrix[i][j];
                if(x == 0) continue;
                boolean flag = true;

                for(int val=x+1; val<=200 && flag; val++){
                    for(int[] arr : list[val]){

                        int nr = arr[0];
                        int nc = arr[1];

                        int x1 = Math.abs(nr - i);
                        int y1 = Math.abs(nc - j);

                        if(x1 <= x && y1 <= x){

                            if(x1 == x && y1 == x){
                                continue;
                            }

                            flag = false;
                            break;
                        }
                    }
                }
                if(flag) ans++;
            }
        }
        return ans;
    }
}