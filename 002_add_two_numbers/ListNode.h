#include <iostream>
#include <string>
#include <sstream>
#include <iterator>

class vector<string>;

class ListNode {
private:
    int val;
    ListNode *next;
public:
    ListNode(int x) : val(x), next(NULL) {}
    ListNode(vector<string>& vect);
};

template<typename T>
std::ostream& operator<<(std::ostream& os, ListNode node)
{
    os<<"[";
    // cout << vec.size() << endl;
    if(vec.size()!=0)
    {
        std::copy(vec.begin(), vec.end()-1, std::ostream_iterator<T>(os, ", "));
        os << vec.back();
    }
    os<<"]";
    return os;
}