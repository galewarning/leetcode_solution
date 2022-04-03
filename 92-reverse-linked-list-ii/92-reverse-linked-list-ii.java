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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) return null;
        if (left >= right) return head;
        ListNode dummy = new ListNode(-1, head);
        
        ListNode cur = dummy;
        ListNode pre = null;
        ListNode temp = null;
        for (int i = 0; i < left; i++) {
            pre = cur;
            cur = cur.next;
        }
        
        ListNode l = pre;
        ListNode r = cur;
        pre = null;
        
        for (int i = left; i <= right; i++) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        
        r.next = cur;
        l.next = pre;
        
        
        
        return dummy.next;
    }
}