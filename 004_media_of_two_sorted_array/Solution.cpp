#include <vector>
#include <string>
#include <cstdio>

#include "../IO.h"

class Solution {
public:
    double findMedianSortedArrays(const vector<int>& x, const vector<int>& y) {
        // make sure y is longer than x
        if (x.size() > y.size()) {
            return findMedianSortedArrays(y, x);
        }
        int xlen = x.size(), ylen = y.size(), a, b, v = 0;
        if (xlen == 0) {
            if (ylen % 2 == 0) {
                return (0.0 + y[ylen / 2 - 1] + y[ylen / 2]) / 2;
            } else {
                return y[ylen / 2];
            }
        }
        if ((x.size() + y.size()) % 2 == 1) {
            v = x.back();
            xlen--;
        }
        if (xlen == 0) {
            a = y[ylen / 2 - 1];
            b = y[ylen / 2];
        } else if (xlen == 1) {
            if (ylen == 1) {
                a = min(x[0], y[0]);
                b = max(x[0], y[0]);
            } else {
                int i = ylen / 2;
                if (x[0] > y[i]) {
                    a = y[i];
                    b = min(x[0], y[i + 1]);
                } else {
                    a = max(x[0], y[i - 1]);
                    b = y[i];
                }
            }
        } else {
            int xl = 0, xr = xlen - 1;
            int ymid, xmid, midIndex = (xlen + ylen) / 2 - 1;
            if (x[xr] < y[midIndex - xr]) {
                a = x[xlen - 1];
                if (xlen != ylen) {
                    a = max(a, y[(ylen - xlen) / 2 - 1]);
                }
                b = y[(ylen - xlen) / 2];
            } else if (y[midIndex - xl] < x[xl]) {
                a = y[(ylen + xlen) / 2 - 1];
                b = x[0];
                if (xlen != ylen) {
                    b = min(b, y[(ylen + xlen) / 2]);
                }
            } else {
                while (xr - xl > 1) {
                    xmid = (xl + xr) / 2;
                    ymid = midIndex - xmid;
                    if (y[ymid] < x[xmid]) {
                        xr = xmid;
                    } else if (x[xmid] < y[ymid]) {
                        xl = xmid;
                    } else {
                        xl = xmid - 1;
                        xr = xmid;
                        break;
                    }
                }
                a = max(x[xl], y[midIndex - xr]);
                b = min(x[xr], y[midIndex - xl]);
            }
        }
        if ((x.size() + y.size()) % 2 == 1) {
            if (v < a)
                return a;
            else if (v > b)
                return b;
            else
                return v;
        } else {
            return (0.0 + a + b) / 2;
        }
    }
};

int main (int argc, char** argv) {
    Solution sol;
    while(true){
        vector<int> a, b;
        cin >> a;
        cin >> b;
        if (!cin)
            break;
        double ans = sol.findMedianSortedArrays(a, b);
        printf("%0.1f\n", ans);
    }
    return 0;
}

