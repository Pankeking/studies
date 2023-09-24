class RecurseMemoSolution(object):
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

class IterDoubleVarSolution(object):
    def rob(self, nums):
        prev1 = 0
        prev2 = 0
        for num in nums:
            tmp = prev1
            prev1 = max(prev2 + num, prev1)
            prev2 = tmp
    
        return prev1

iterable = IterDoubleVarSolution()
memoRecurse = RecurseMemoSolution()
test1 = [1,2,3,1]
test2 = [2,1,1,2]


iterableResults = [iterable.rob(test1), iterable.rob(test2)]
memoResults = [memoRecurse.rob(test1), memoRecurse.rob(test2)]
print(iterableResults)
print(memoResults)


