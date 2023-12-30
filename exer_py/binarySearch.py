from time_deco import deco

def binary_search(nums,target):
    lo = 0
    hi = len(nums)
    while lo < hi:
        mid = lo + (hi - lo) // 2
        if nums[mid] == target:
            return mid
        elif nums[mid] > target:
            hi = mid
        else: 
            lo = mid + 1
    return -1
    

@deco
def search(nums, lo, hi ,target):
    if lo > hi:
        return -1
    mid = lo + (hi - lo) // 2
    if nums[mid] == target:
        return mid
    elif nums[mid] > target:
        return search(nums, lo, mid - 1, target)
    else:
        return search(nums, mid + 1, hi, target)
    

# test = int(input())
nums = [1,2,3,4,5,7,8,9,10]
for test in range(-1, 15):
    # print(binary_search(nums, test))
    print(search(nums, 0, len(nums) - 1, test))
    

    