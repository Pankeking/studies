'''
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

 

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
'''
import collections

def longestConsecutive(nums: list[int]) -> int:
    numSet = set(nums)
    length = 1
    longest = 1
    for num in numSet:
        if num - 1 not in numSet:
            while num + length in numSet:
                    length += 1
            longest = max(longest, length)
            
        
      
    
    return longest
  
nums = [0,3,7,2,5,8,4,6,0,1]
nums1 = [100,4,200,1,3,2]

print(longestConsecutive(nums))
print(longestConsecutive(nums1))