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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode output = new ListNode(0);
        // 用cur把output的iteration留在初始
        ListNode cur = output;
        ListNode p1 = l1, p2 = l2;
        int sum = 0;
        while(p1 != null || p2 != null || sum!=0) {
            if(p1 != null) {
                sum += p1.val;
                p1 = p1.next;
            }
            if(p2 != null) {
                sum += p2.val;
                p2 = p2.next;
            }
            //只有初始赋值，没有改变值的方法
            cur.next = new ListNode(sum % 10);
            sum = sum/10;
            cur = cur.next;
        }
        return output.next;
    }
}