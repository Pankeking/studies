import sys

if len(sys.argv) != 2:
    print("Usage: shell_sort.py <input_file>")
    sys.exit(1)

file_path = sys.argv[1]

numbers = read_file(file_path)

def read_file(file_path)
    numbers = []
    with open(file_path, 'r') as file:
        numbers.extend(int(line.strip()) for line in file)
    return numbers

def sort(arr):
    return

def