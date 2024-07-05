/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    final int N = 100_000;
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode prev = null;
        ListNode now = head;
        int idx = 1;
        int[] arr = new int[3];
        Arrays.fill(arr, -1);
        int cur = 0;
        int l = -1;
        int r = -1;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        while (now.next != null) {
            if (prev != null) {
                int a = prev.val;
                int b = now.next.val;
                if ((a < now.val && b < now.val) || (a > now.val && b > now.val)) {
                    if (l == -1) {
                        l = idx;
                    } else if (r == -1) {
                        r = idx;
                        max = r - l;
                        min = r - l;
                    } else {
                        max = Math.max(max, idx - l);
                        min = Math.min(min, idx - r);
                        r = idx;
                    }
                }
            }
            prev = now;
            now = now.next;
            idx++;
        }
        if (l == -1 || r == -1) {
            return new int[]{-1, -1};
        }
        if (max == Integer.MIN_VALUE || min == Integer.MAX_VALUE) {
            max = min = r - l;
        }
        return new int[]{min, max};
    }
}