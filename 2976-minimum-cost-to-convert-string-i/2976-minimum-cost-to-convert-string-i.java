import java.util.*;
class Solution {
    final int N = 26;
    final int MAX = 1_000_000_000;
    int[][] dist = new int[N + 1][N + 1];
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        for (int i = 0; i <= N; i++) {
            Arrays.fill(dist[i], MAX);
        }
        for (int i = 0; i <= N; i++) {
            dist[i][i] = 0;
        }
        for (int i = 0; i < original.length; i++) {
            int u = original[i] - 'a';
            int v = changed[i] - 'a';
            dist[u][v] = Math.min(dist[u][v], cost[i]);
        }
        for (int k = 0; k <= N; k++) {
            for (int i = 0; i <= N; i++) {
                for (int j = 0; j <= N; j++) {
                    if (dist[i][k] < MAX && dist[k][j] < MAX) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
        
        long ans = 0;
        for (int i = 0; i < source.length(); i++) {
            int u = source.charAt(i) - 'a';
            int v = target.charAt(i) - 'a';
            if (dist[u][v] == MAX) {
                return -1L;
            }
            ans += dist[u][v];
        }
        return ans;
    }


}