import time
import sys

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
        
    def read_file(self, file_path):
        numbers = []
        with open(file_path, 'r') as file:
            numbers.extend(int(line.strip()) for line in file)
        return numbers


if len(sys.argv) != 2:
    print("Usage: python 3waydijkstra.py <input_file>")
    sys.exit(1)
    
file_path = sys.argv[1]

test = Solution()
numbers = test.read_file(file_path)

start_time = time.time()

test.sort(numbers, 0, len(numbers) - 1)

end_time = time.time()
elapsed_time = (end_time - start_time) * 1000

print(f"Python 3-way Dijkstra's Quick Sort: {int(elapsed_time)}ms")
