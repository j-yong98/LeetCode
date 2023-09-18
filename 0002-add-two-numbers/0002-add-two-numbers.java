class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode();
        int carry = 0;
        ListNode pointer = ans;
        while (l1 != null && l2 != null) {
            ListNode cur = new ListNode();
            int sum = l1.val + l2.val + carry;
            cur.val = sum % 10;
            carry = sum / 10;
            pointer.next = cur;
            pointer = cur;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            ListNode cur = new ListNode();
            int sum = l1.val + carry;
            cur.val = sum % 10;
            carry = sum / 10;
            pointer.next = cur;
            pointer = cur;
            l1 = l1.next;
        }
        while (l2 != null) {
            ListNode cur = new ListNode();
            int sum = l2.val + carry;
            cur.val = sum % 10;
            carry = sum / 10;
            pointer.next = cur;
            pointer = cur;
            l2 = l2.next;
        }
        if (carry != 0) {
            pointer.next = new ListNode(carry);
        }
        return ans.next;
    }    
}