def removeDuplicates(nums):
    """
    :type nums: List[int]
    :rtype: int
    """
    k = len(nums)
    end = k - 1
    current = k - 1
    while current >= 2:
        if nums[current] == nums[current - 2]:
            nums[current], nums[end] = nums[end], nums[current] 
            end -= 1
            
        current -= 1
    print(nums)
    return end + 1
    

nums = [1,1,2,2,2,3,3,4]
print(removeDuplicates(nums))
