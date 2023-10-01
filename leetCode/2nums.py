class Solution(object):
    def twoSum(self, nums: list[int], target: int) -> list[int]: 
        table = {}
        
        for i, n in enumerate(nums):
            diff = target - n
            if diff in table:
                return [table[diff], i]
            table[n] = i
        return []

test = Solution()

nums1 = [2,7,11,15]
nums2 = [3,2,4]
nums3 = [3,3]
print(test.twoSum(nums1, 9))
print(test.twoSum(nums2, 6))
print(test.twoSum(nums3, 6))