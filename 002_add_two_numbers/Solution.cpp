#include <iostream>
#include <vector>
#include <string>
#include <sstream>
#include <unordered_map>
#include <cstdlib> 
#include <algorithm>
#include <iterator>
#include "ListNode.cpp"

using namespace std;

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


vector<string> split(const string &s, char delim) {
    stringstream ss(s);
    string item;
    vector<string> tokens;
    while (getline(ss, item, delim)) {
        tokens.push_back(item);
    }
    return tokens;
}

int main (int argc, char** argv) {
  string rawInput;
  while(true){
    vector<int> ls, ls2;
    int target;
    Solution sol;
 
    // Please enter list of number:
    if (!getline(cin, rawInput))
      break;
    vector<string> strs = split(rawInput, ' ');
    for (string i: strs)
      ls.push_back(atoi(i.c_str()));

    // Please enter the target:
    if (!getline(cin, rawInput))
      break;
    strs = split(rawInput, ' ');
    for (string i: strs)
      ls2.push_back(atoi(i.c_str()));

    // vector<int> ans = sol.twoSum(ls, target);
    // cout << ans << endl;
  }
  return 0;
}
