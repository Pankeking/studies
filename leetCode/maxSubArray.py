class Solution:
    def maxSubArray(self, nums: list[int]) -> int:
        maxSum = nums[0]
        currentSum = 0
        
        for num in nums:
            currentSum = max(currentSum + num, num)
            maxSum = max(currentSum, maxSum)
        
        return maxSum
            
            
        
        
test = Solution()

nums1 = [-2,1,-3,4,-1,2,1,-5,4]
nums2 = [5,4,-1,7,8]
nums3 = [1]
print(test.maxSubArray(nums1))
print(test.maxSubArray(nums2))
print(test.maxSubArray(nums3))