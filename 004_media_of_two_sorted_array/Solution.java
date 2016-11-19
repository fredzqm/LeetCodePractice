import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public double findMedianSortedArrays(int[] x, int[] y) {
        // make sure y is longer than x
        if (x.length > y.length) {
            int[] z = x;
            x = y;
            y = z;
        }
        int xlen = x.length, ylen = y.length, a, b, v = Integer.MIN_VALUE;
        if (xlen == 0) {
            if (ylen % 2 == 0) {
                return (0.0 + y[ylen / 2 - 1] + y[ylen / 2]) / 2;
            } else {
                return y[ylen / 2];
            }
        }
        if ((x.length + y.length) % 2 == 1) {
            xlen--;
            v = x[xlen];
        }
        if (xlen == 0) {
            a = y[ylen / 2 - 1];
            b = y[ylen / 2];
        } else if (xlen == 1) {
            if (ylen == 1) {
                a = Math.min(x[0], y[0]);
                b = Math.max(x[0], y[0]);
            } else {
                int i = ylen / 2;
                if (x[0] > y[i]) {
                    a = y[i];
                    b = Math.min(x[0], y[i + 1]);
                } else {
                    a = Math.max(x[0], y[i - 1]);
                    b = y[i];
                }
            }
        } else {
            int xl = 0, xr = xlen - 1;
            int ymid, xmid, midIndex = (xlen + ylen) / 2 - 1;
            if (x[xr] < y[midIndex - xr]) {
                a = x[xlen - 1];
                if (xlen != ylen) {
                    a = Math.max(a, y[(ylen - xlen) / 2 - 1]);
                }
                b = y[(ylen - xlen) / 2];
            } else if (y[midIndex - xl] < x[xl]) {
                a = y[(ylen + xlen) / 2 - 1];
                b = x[0];
                if (xlen != ylen) {
                    b = Math.min(b, y[(ylen + xlen) / 2]);
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
                a = Math.max(x[xl], y[midIndex - xr]);
                b = Math.min(x[xr], y[midIndex - xl]);
            }
        }
        if ((x.length + y.length) % 2 == 1) {
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

    public static double findMean(int[] x, int xl, int xr) {
        if ((xl - xr) % 2 == 0) {
            int i = (xl + xr) / 2;
            return (0.0 + x[i] + x[i - 1]) / 2;
        } else {
            return x[(xl + xr) / 2];
        }
    }

	public static void main(String[] args) {
		IO in = new IO();
		Solution sol = new Solution();
		while (in.hasNext()) {
			int[] a = in.nextIntArray();
            int[] b = in.nextIntArray();
			double ans = sol.findMedianSortedArrays(a, b);
			System.out.printf("%.1f\n", ans);
		}
	}
}