// #include <iostream>
// #include <vector>
// #include <sstream>
#include <unordered_map>
// #include <iterator>

#include "../IO.h"

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


int main (int argc, char** argv) {
  Solution sol;
  while(true){
    vector<int> ls;
    int target;
    cin >> ls;
    cin >> target;
    if (!cin)
      break;
    vector<int> ans = sol.twoSum(ls, target);
    cout << ans << endl;
  }
  return 0;
}



