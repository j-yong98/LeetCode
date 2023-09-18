import java.util.*;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Node[] arr = new Node[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = new Node(i, nums[i]);
        }
        Arrays.sort(arr, (a, b) -> Integer.compare(a.val, b.val));
        int[] ans = new int[2];
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int sum = arr[l].val + arr[r].val;
            if (sum == target) {
                ans[0] = Math.min(arr[l].idx, arr[r].idx);
                ans[1] = Math.max(arr[l].idx, arr[r].idx);
                break;
            } else if (sum > target)
                r--;
            else
                l++;
        }
        return ans;
    }
    static class Node {
        int idx;
        int val;
        
        public Node(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }
}