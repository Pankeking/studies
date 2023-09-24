class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        memo = [-1] * len(nums)
        return self.thief(memo, nums, len(nums) - 1)

    def thief(self, memo, nums, i):
        if i < 0:
            return 0
        if memo[i] >= 0:
            return memo[i]
        memo[i] = max(self.thief(memo, nums, i - 2) + nums[i], self.thief(memo, nums, i - 1))
        return memo[i]
