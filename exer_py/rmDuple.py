def removeDuplicates(nums):
    """
    :type nums: List[int]
    :rtype: int
    """
    i = 0
    for num in nums:
        if i < 2 or num > nums[i - 2]:
            nums[i] = num
            i += 1
    print(i)
    nums = nums[:i]
    print(nums)
    return i

nums = [1,1,2,2,2,3,4,5]
print(removeDuplicates(nums))
print(nums)

1,1,2,2,3,4,5,5