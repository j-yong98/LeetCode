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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int len = 1;
        ListNode cursor = head;
        while (cursor.next != null) {
            len++;
            cursor = cursor.next;
        }

        k = k % len;
        int n = len - k;

        ListNode tmp = head;
        for (int i = 0; i < n - 1; i++) { 
            tmp = tmp.next;
        }

        cursor.next = head;
        head = tmp.next;
        tmp.next = null;
        return head;
    }
}