import sys
import time

if len(sys.argv) != 2:
    print("Usage: shell_sort.py <input_file>")
    sys.exit(1)

file_path = sys.argv[1]

numbers = read_file(file_path)

start_time = time.time()
sort(numbers)
end_time = time.time()
elapsed_time = (end_time - start_time) * 1000

print(f"Python shell elapsed time: {int(elapsed_time)}")
print(numbers)

def read_file(file_path)
    numbers = []
    with open(file_path, 'r') as file:
        numbers.extend(int(line.strip()) for line in file)
    return numbers

def sort(arr):
    length = len(arr)
    
    h_sort = 0
    while h_sort < length:
        h_sort = h_sort * 3 + 1
    
    

def