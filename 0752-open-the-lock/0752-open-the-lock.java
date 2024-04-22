class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> vis = new HashSet<>(Arrays.asList(deadends));
        Queue<String> q = new LinkedList<>();
        if (vis.contains("0000")) {
            return -1;
        }
        q.offer("0000");
        int level = 0;
        while (!q.isEmpty()) {

            int size = q.size();
            while (size > 0) {
                String curr = q.poll();
                if (curr.equals(target)) {
                    return level;
                }
                
                findAllNeighbours(curr, vis, q);
                size--;
            }
            level++;
        }
        return -1;
    }

public void findAllNeighbours(String curr, HashSet<String> vis, 
Queue<String> q) {
    char[] ch = curr.toCharArray();
    for (int i = 0; i < 4; i++) {
        char c = ch[i];

        ch[i] = c == '9' ? '0' : (char) (c + 1);
        if(!vis.contains(String.valueOf(ch))){
            vis.add(String.valueOf(ch));
            q.offer(String.valueOf(ch));
        }
        ch[i] = c == '0' ? '9' : (char) (c - 1);
        if(!vis.contains(String.valueOf(ch))){
            vis.add(String.valueOf(ch));
            q.offer(String.valueOf(ch));
        }
        ch[i] = c;
    }
}
}