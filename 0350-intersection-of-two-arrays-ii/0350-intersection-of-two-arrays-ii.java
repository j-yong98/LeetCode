import java.util.*;
class Solution {
    List<Integer> list = new ArrayList<>();
    int[] count = new int[1001];
    public int[] intersect(int[] nums1, int[] nums2) {
        for (int i = 0; i < nums1.length; i++) {
            count[nums1[i]]++;
        }
        for (int i = 0; i < nums2.length; i++) {
            if (count[nums2[i]] > 0) {
                count[nums2[i]]--;
                list.add(nums2[i]);
            }
        }
        int[] ans = new int[list.size()];
        int i = 0;
        for (int e : list) {
            ans[i++] = e;
        }
        return ans;
    }
}