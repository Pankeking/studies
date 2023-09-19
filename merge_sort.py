import sys

def sort(arr):
    if len(arr) <= 1:
        return arr
    
    mid = len(arr) // 2
    left_half = sort(arr[:mid])
    right_half = sort(arr[mid:])
    merge(left_half, right_half)
    
def merge(left,right):
    merged = []
    left_index = 0
    right_index = 0
    
    while left_index < ln(left) and right_index < len(right):
        if left[left_index] < right[right_index]:
            merged.append(left[left_index])
            left_index += 1
        else:
            merged.append(right[right_index])
            right_index += 1
    
    merged.extend(left[left_index:])
    merged.extend(right[right_index:])
    
    return merged

def read_file(file_path):
    numbers = []
    with open(file_path, 'r') as file:
        numbers.extend(int(line.strip()) for line in file)
        
    return numbers

if len(sys.argv) != 2:
    print("Usage: python merge_sort.py <input_file>")
    sys.exit(1)

file_path = sys.argv[1]
numbers = read_file(file_path)

sorted_numbers = sort(numbers)