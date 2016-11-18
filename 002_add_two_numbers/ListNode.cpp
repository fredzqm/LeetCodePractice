#include <iostream>
#include <vector>
#include <string>
#include <sstream>
#include <iterator>

#include "ListNode.h"

using namespace std;

ListNode::ListNode(vector<string>& vect) {
    ListNode* cur = this;
    this-> val = atoi(vect.front());
    for (auto it = vect.begin()+1; it != vect.end(); it++) {
        cur->next = new ListNode(atoi(it->c_str()));
        cur = cur->next;
    }
}
