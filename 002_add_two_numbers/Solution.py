# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        return self.helper(l1, l2, 0);
    
    def helper(self, l1, l2, addOne):
        if l1 == None and l2 == None:
            if addOne == 1:
                return ListNode(1)
            return None
        v = addOne
        l1n = None
        l2n = None
        if l1 != None:
            v += l1.val
            l1n = l1.next
        if l2 != None:
            v += l2.val
            l2n = l2.next
        ret = ListNode(v % 10);
        ret.next = self.helper(l1n, l2n, v // 10)
        return ret;