import random
#
class Solution(object):
    
    def quickSort(self, nums):
        random.shuffle(nums)
        self.sort(nums, 0, len(nums) - 1)
    def sort(self, nums, low, hi):
        if hi <= low: return
        mid = self.partition(nums, low, hi)
        self.sort(nums, low, mid - 1)
        self.sort(nums, mid + 1, hi)
        
    def partition(self, nums, low, hi):
        left = low
        right = hi
        while True:
            # scan from left to right
            while nums[left] < nums[low]:
                left += 1
                if left == hi:
                    break
            # scan from right to left
            while nums[low] < nums[right]:
                right -= 1
                if right == low:
                    break
                
            if left >= right:
                break
            nums[right], nums[left] = nums[left], nums[right]
            
        
        nums[low], nums[right] = nums[right], nums[low]
        return right
        
        
test = Solution()

testNums = [3, 7, 11, 2, 9, 4, 12]        
test.quickSort(testNums)
print(testNums)

test1 = [0,0,0,1,1,1]
test.quickSort(test1)
print(test1)