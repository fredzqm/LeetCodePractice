/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var addTwoNumbers = function(l1, l2) {
    function helper(a, b, addOne){
        if (a === null && b === null){
            if (addOne == 1){
                return new ListNode(1);
            }
            return null;
        }
        var v = addOne;
        var n1 = null;
        var n2 = null;
        if (a !== null){
            v += a.val;
            n1 = a.next;
        }
        if (b !== null){
            v += b.val;
            n2 = b.next;
        }
        var ret = new ListNode(v % 10);
        ret.next = helper(n1, n2, Math.floor(v / 10));
        return ret;
    }
    
    return helper(l1, l2, 0);
};