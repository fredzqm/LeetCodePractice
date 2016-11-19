#include <unordered_set>
#include <string>

#include "../IO.h"

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_set<char> set;
        int j = 0, max = 0;
        for (int i = 0; i < s.length(); i++){
            char c = s.at(i);
            if (set.find(c) == set.end()){
                set.insert(c);
            } else {
                if (i - j > max)
                    max = i - j;
                while (s.at(j) != c){
                    set.erase(s.at(j));
                    j++;
                }
                j++;
            }
        }
        if (s.length() - j > max)
            max = s.length() - j;
        return max;
    }
};

int main (int argc, char** argv) {
  Solution sol;
  while(true){
  	string s;
    cin >> s;
    if (!cin)
      break;
    int ans = sol.lengthOfLongestSubstring(s);
    cout << ans << endl;
  }
  return 0;
}



