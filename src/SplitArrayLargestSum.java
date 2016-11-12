/**
 * https://leetcode.com/problems/split-array-largest-sum/
 * 
 * @author zhang
 *
 */
public class SplitArrayLargestSum {
	
    public static int splitArray(int[] nums, int m) {
         int[] idxs = new int[m+1];
         int[] sums = new int[m+1];
         int sum = 0, max = 0;
         for (int i = 0; i < nums.length; i++){
             sum += nums[i];
             max = Math.max(max, nums[i]);
         }
         int min = Math.max(sum / m, max);
         int seg = 0; sum = 0;
        //  int minNext = Integer.MAX_VALUE, minIndex = 0;
         for (int i = 0 ; i < nums.length; i++) {
             sum += nums[i];
             if (sum - sums[seg] > min && seg < m){
                 seg++;
                 idxs[seg] = i;
                 sums[seg] = sum - nums[i];
                //  if (sums[seg] + nums[i] - sums[seg-1] < minNext){
                //      minNext = sums[seg] - sums[seg-1];
                //      minIndex = seg;
                //  }
             }
         }
         if (seg != m){
             return min;
         }
         while(true){
             int minNext = Integer.MAX_VALUE, minIndex = 0;
             for (seg = 1 ; seg <= m ; seg ++) {
                 int next = sums[seg] + nums[idxs[seg]] - sums[seg-1];
                 if (next < minNext){
                     minNext = next;
                     minIndex = seg;
                 }
             }
             min = minNext;
             for (seg = minIndex; seg <= m; seg ++){
                 while (sums[seg] + nums[idxs[seg]] - sums[seg-1] <= minNext){
                     sums[seg] += nums[idxs[seg]];
                     idxs[seg]++;
                     if (idxs[seg] >= nums.length)
                        return minNext;
                 }
             }
         }
    }
    
    public static void main(String args[]){
    	System.out.println(splitArray(new int[]{7,2,5,10,8}, 2));
    }
}