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
}