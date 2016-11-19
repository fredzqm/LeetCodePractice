# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x, ls = None):
        self.val = x
        self.next = None


    def __str__(self):
        if self.next == None:
            return str(self.val)
        return str(self.val) + " " + str(self.next)

def createNode(i, ls):
    x = ListNode(ls[i]);
    if i+1 != len(ls):
        x.next = createNode(i+1, ls);
    return x;

class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        return self._helper(l1, l2, 0);
    
    def _helper(self, l1, l2, addOne):
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
        ret.next = self._helper(l1n, l2n, v // 10)
        return ret;


if __name__ == '__main__':
  try:
    sol = Solution()  
    while (True):
      ls_a = [int(x) for x in input().split()]
      ls_b = [int(x) for x in input().split()]
      a = createNode(0, ls_a);
      b = createNode(0, ls_b);
      ans = sol.addTwoNumbers(a, b)
      print(ans)
  except EOFError:
    pass