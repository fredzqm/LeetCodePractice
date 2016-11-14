#include <iostream>
#include <vector>
#include <string>
#include <sstream>
#include <unordered_map>
#include <cstdlib> 
#include <algorithm>
#include <iterator>

using namespace std;

class Solution {
public:
  vector<int> twoSum(vector<int>& nums, int target) {
    unordered_map<int, int> m;
    vector<int> ret;
    for (int i = 0; i < nums.size(); i++){
      int comp = target - nums[i];
      if (m.find(comp) != m.end()){
        ret.push_back(m.find(comp)->second);
        ret.push_back(i);
        return ret;
      }
      pair<int,int> added(nums[i], i);
      m.insert(added);
    }
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

template<typename T>
std::ostream& operator<<(std::ostream& os, std::vector<T> vec)
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



int main (int argc, char** argv) {
  string rawInput;
  while(true){
    vector<int> ls;
    int target;
    Solution sol;
 
    cout << "Please enter list of number:" << endl;
    getline(cin, rawInput);
    vector<string> strs = split(rawInput, ' ');
    for (string i: strs)
      ls.push_back(atoi(i.c_str()));

    cout << "Please enter the target:" << endl;
    getline(cin, rawInput);
    target = atoi(rawInput.c_str());

    vector<int> ans = sol.twoSum(ls, target);
    cout << "The answer is: " << ans << endl;
  }
}



