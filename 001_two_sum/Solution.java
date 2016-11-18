import java.util.HashMap;
import java.util.Arrays;

public class Solution {
  public int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> set = new HashMap<>();
    for (int i = 0 ; i < nums.length; i ++){
      int x = nums[i];
      if (set.containsKey(target - x)){
        return new int[]{set.get(target - x), i};
      }
      set.put(x, i);
    }
    return null;
  }


  public static void main(String[] args) {
    IO io = new IO();
    Solution sol = new Solution();
    while (io.hasNext()) {
      int[] nums = io.nextIntArray();
      int target = io.nextInt();
      int[] ans = sol.twoSum(nums, target);
      io.println(ans);
    }
  }
}