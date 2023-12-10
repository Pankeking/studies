import collections

def freq_item(nums, k):
        count = {}
        freq = [[] for _ in range(len(nums) + 1)]
        
        
        # Initialization
        for n in nums:
          count[n] = 1 + count.get(n, 0)
        for key, value in count.items():
          freq[value].append(key)
        
        result = []  
        for i in range(len(freq) - 1, 0, -1):
          for num in freq[i]:
            result.append(num)
            if len(result) == k:
              return result
            
            
          
          
      
nums = []
ks = []
nums.append([1,1,1,2,2,3])
ks.append(2)

nums.append([1])
ks.append(1)

nums.append([1, 2])
ks.append(2)

nums.append([4,1,-1,2,-1,2,3])
ks.append(2)

result = []

for i, num in enumerate(nums):
  result.append(freq_item(num, ks[i]))
  
for r in result:
  print(r)