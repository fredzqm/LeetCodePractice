class Solution(object):
  def twoSum(self, nums, target):
    """
    :type nums: List[int]
    :type target: int
    :rtype: List[int]
    """
    s = {};
    for i in range(len(nums)):
      comp = target - nums[i];
      if comp in s:
          return [s[comp], i];
      s[nums[i]] = i;


if __name__ == '__main__':
  try:
    while (True):
      sol = Solution()
      nums = [int(x) for x in input().split()]
      target = int(input())
      ans = sol.twoSum(nums, target)
      print(ans)
  except EOFError:
    pass

