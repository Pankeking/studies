import random
#
class Solution(object):
    
    def quickSort(self, nums):
        random.shuffle(nums)
        self.sort(nums, 0, len(nums) - 1)
    def sort(self, nums, lo, hi):
        '''
        
        3 7 11 9 2 4 12 
        
        .partition()
        for some j
        a[j] is in place
        left of a[j] no larger than a[j]
        right of a[j] no smaller than a[j]
        .sort()
        '''
        if hi <= lo: return
        mid = partition(nums, lo, hi)
        sort(nums, lo, mid - 1)
        sort(nums, mid + 1, hi)
        
    def partition(self, nums, lo, hi):
        
        
        
testNums = [3, 7, 11, 2, 9, 4, 12]        
test.Solution()
test.quickSort(testNums)