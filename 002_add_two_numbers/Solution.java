/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return helper(l1, l2, 0);
    }
    public ListNode helper(ListNode l1, ListNode l2, int addOne) {
        int v = addOne;
        ListNode next1 = null, next2 = null;
        if (l1 == null && l2 == null){
            if (addOne == 1){
                return new ListNode(1);
            } else {
                return null;
            }
        } 
        if (l2 != null){
            v += l2.val;
            next2 = l2.next;
        }
        if (l1 != null){
            v += l1.val;
            next1 = l1.next;
        }
        ListNode ret = new ListNode(v % 10);
        ret.next = helper(next1, next2, v / 10);
        return ret;
    }
}