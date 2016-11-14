/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        return helper(l1, l2, 0);
    }
private:
    ListNode* helper(ListNode* l1, ListNode* l2, int addOne){
        if (l1 == NULL && l2 == NULL){
            if (addOne == 1)
                return new ListNode(addOne);
            return NULL;
        }
        int v = addOne;
        ListNode *n1 = NULL, *n2 = NULL;
        if (l1 != NULL){
            v += l1->val;
            n1 = l1->next;
        }
        if (l2 != NULL){
            v += l2->val;
            n2 = l2->next;
        }
        ListNode* ret = new ListNode(v % 10);
        ret->next = helper(n1, n2, v / 10);
        return ret;
    }
};