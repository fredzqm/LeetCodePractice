#include <algorithm>
#include <iostream>
#include <fstream>
#include <string>
#include <sstream>
#include <unordered_set>

using namespace std;

int main (int argc, char** argv) {
   string line;
   ifstream in(argv[1]);
   if (in.is_open()) {
      unordered_set<char> ignore({'[', ']', ',', '{', '}'});
      while (getline(in,line)) {
         bool space = true;
         for (string::iterator it = line.begin(); it < line.end(); it++) {
            if (ignore.count(*it) == 0) {
               if (*it == ' ') {
                  if (!space) {
                     cout << *it;
                     space = true;
                  }
               } else {
                  cout << *it;
                  space = false;
               }
            }
         }
         cout << endl;
      }
      in.close();
   }
   return 0;
}