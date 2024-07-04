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
    public ListNode mergeNodes(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.next.val == 0) {
                prev = cur;
                cur = cur.next;
            } else {
                cur.val += cur.next.val;
                cur.next = cur.next.next;
            }
        }
        prev.next = null;
        return head;
    }
}