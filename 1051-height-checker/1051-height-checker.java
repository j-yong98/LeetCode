import java.util.*;
class Solution {
    public int heightChecker(int[] heights) {
        int[] copy = Arrays.copyOf(heights, heights.length);
        Arrays.sort(copy);
        int cnt = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != copy[i]) {
                cnt++;
            }
        }
        return cnt;
    }
}