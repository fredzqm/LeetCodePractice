#include <iostream>
#include <vector>
#include <string>
#include <iterator>

#include "../IO.h"

using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
    ListNode(const vector<int>::iterator& cur, const vector<int>::iterator& end) {
        this-> val = *cur;
        if (cur+1 == end) 
            this -> next = NULL;
        else
            this -> next = new ListNode(cur+1, end);
    }
    ~ListNode() {
        delete next;
    }
};

ostream& operator<<(ostream& os, const ListNode* node)
{
    os << node->val << " ";
    if (node->next != NULL)
        os << node->next;
    return os;
}


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


int main (int argc, char** argv) {
  Solution sol;
  while(true){
    vector<int> ls_a, ls_b;
    cin >> ls_a;
    cin >> ls_b;
    ListNode* a = new ListNode(ls_a.begin(), ls_a.end());
    ListNode* b = new ListNode(ls_b.begin(), ls_b.end());
    if (!cin)
        break;
    ListNode* ans = sol.addTwoNumbers(a, b);
    cout << ans << endl;
    delete a, b, ans;
  }
  return 0;
}
