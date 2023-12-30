nums = [1,2,3,4]
result = [1] * len(nums)
current = 1
for i in range(len(nums)):
    result[i] *= current
    current *= nums[i]

current = 1
for i in range(len(nums) - 1, -1, -1):
    result[i] *= current
    current *= nums[i]
    
print(result)
