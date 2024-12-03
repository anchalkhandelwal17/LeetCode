class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {

        HashSet<String> set = new HashSet<>();
        for (String s : bank) {
            set.add(s);
        }

        char[] ch = { 'A', 'C', 'G', 'T' };

        Queue<String> q = new LinkedList<>();
        Set<String> vis = new HashSet<>();
        q.offer(startGene);
        vis.add(startGene);
        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {

                String curr = q.poll();
                if (curr.equals(endGene))
                    return level;
                
                char[] c = curr.toCharArray();
                for(int j=0; j<c.length; j++){
                    char old = c[j];
                    for(int k=0; k<4; k++){
                        c[j] = ch[k];

                        String newStr = new String(c);

                        if(set.contains(newStr) && !vis.contains(newStr)){
                            q.offer(newStr);
                            vis.add(newStr);
                        }
                    }
                    c[j] = old;
                }
            }
            level++;
        }
        return -1;
    }
}