#include <iostream>
#include <vector>
#include <sstream>
#include <unordered_map>
#include <cstdlib> 
#include <iterator>

using namespace std;

template<typename T>
ostream& operator<<(ostream& os, const vector<T>& vec)
{
    copy(vec.begin(), vec.end(), ostream_iterator<T>(os, " "));
    return os;
}

template<typename T>
istream& operator>>(istream& is, vector<T>& vec)
{
	string line;
	T x;
	getline(is, line);
	if (line.length() == 0)
		getline(is, line);
	istringstream iss(line);
	while (iss >> x) {    
		vec.push_back(x);
	}
    return is;
}