class Solution:
    def removeElement(self, nums: list[int], val: int) -> int:
        end = len(nums) - 1
        start = 0
        while start <= end:
            if nums[start] == val:
                nums[start], nums[end] = nums[end], nums[start]
                end -= 1
            else:
                start += 1
        return 1 + end
    
    

nums1 = [0,1,2,2,3,0,4,2]
val1 = 2
nums2 = [3,2,2,3]
val2 = 3

test = Solution()
print(test.removeElement(nums2, val2))
print(test.removeElement(nums1, val1))