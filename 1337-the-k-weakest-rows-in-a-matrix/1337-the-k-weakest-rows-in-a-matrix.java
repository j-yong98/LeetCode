import java.util.*;
class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.cnt == b.cnt ? a.idx - b.idx : a.cnt - b.cnt);
        for (int i = 0; i < mat.length; i++) {
            int cnt = 0;
            for (int j = 0; j < mat[i].length; j++)
                if (mat[i][j] == 1) cnt += 1;
            pq.add(new Node(i, cnt));
        }
        int[] ans = new int[k];
        int idx = 0;
        while (k-- > 0)
            ans[idx++] = pq.poll().idx;
        System.out.println(Arrays.toString(ans));
        return ans;
    }
    
    static class Node {
        int idx;
        int cnt;
        
        public Node(int idx, int cnt) {
            this.idx = idx;
            this.cnt = cnt;
        }
    }
}