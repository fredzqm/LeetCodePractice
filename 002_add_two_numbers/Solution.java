import java.util.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {

    public static class ListNode {
        int val;
        ListNode next;
        public ListNode(int x) { val = x; }

        public ListNode(int i, int[] ls) {
            val = ls[i];
            if (i + 1 != ls.length) {
                next = new ListNode(i + 1, ls);
            }
        }

        public String toString() {
            if (next == null)
                return "" + val;
            return "" + val + " " + next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return helper(l1, l2, 0);
    }

    private ListNode helper(ListNode l1, ListNode l2, int addOne) {
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

    public static void main(String[] args) {
        IO in = new IO();
        Solution sol = new Solution();
        while (in.hasNext()) {
            int[] ls_a = in.nextIntArray();
            int[] ls_b = in.nextIntArray();
            ListNode a = new ListNode(0, ls_a);
            ListNode b = new ListNode(0, ls_b);
            ListNode ans = sol.addTwoNumbers(a, b);
            System.out.println(ans);
        }
    }
}