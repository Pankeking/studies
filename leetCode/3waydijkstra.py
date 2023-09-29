
class Solution(object):
    def sort(self, nums, low, high):
        if high <= low: 
            return
        
        lowest = low
        greatest = high
        v = nums[low]
        i = low
        
        while i <= greatest:
            if nums[i] < v:
                nums[lowest], nums[i] = nums[i], nums[lowest]
                lowest += 1
                i += 1
            elif nums[i] > v:
                nums[i], nums[greatest] = nums[greatest], nums[i]
                greatest -= 1
            else:
                i += 1
        self.sort(nums, low, lowest - 1)
        self.sort(nums, greatest + 1, high)
        
        

test = Solution()

testNums = [3, 7, 11, 2, 9, 4, 12]        
test.sort(testNums, 0, len(testNums) - 1)
print(testNums)

test1 = [0,0,0,1,1,1]
test.sort(test1, 0, len(test1) - 1)
print(test1)