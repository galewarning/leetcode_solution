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
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        while (pre.next != null && pre.next.next != null) {
            ListNode temp = pre.next.next;
            pre.next.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
            pre = pre.next.next;
        }
        return dummy.next;
    }
}