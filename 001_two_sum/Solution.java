import java.util.HashMap;
import java.util.Scanner;
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


  static Scanner in = new Scanner(System.in);

  public static void main(String[] args) {
  	while (in.hasNextLine()) {
      Solution sol = new Solution();
      String x = in.nextLine();
      String[] sp = x.split(" ");
      int[] nums = new int[sp.length];
      for (int i = 0; i < sp.length; i++)
        nums[i] = Integer.parseInt(sp[i]);

      int target = Integer.parseInt(in.nextLine());
      int[] ans = sol.twoSum(nums, target);
      System.out.println(Arrays.toString(ans));
    }
  }
}