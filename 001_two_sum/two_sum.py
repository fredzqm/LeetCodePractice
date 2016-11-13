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
        