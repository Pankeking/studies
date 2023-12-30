import sys
import time

def main():
    if len(sys.argv) != 2:
        print("Usage: shell_sort.py <input_file>")
        sys.exit(1)

    file_path = sys.argv[1]

    numbers = read_file(file_path)
    start_time = time.time()
    sort(numbers)
    end_time = time.time()
    elapsed_time = (end_time - start_time) * 1000

    print(f"Python Shell sort: {int(elapsed_time)}ms")

def read_file(file_path):
    numbers = []
    with open(file_path, 'r') as file:
        numbers.extend(int(line.strip()) for line in file)
    return numbers

def sort(arr):
    length = len(arr)
    
    # h positions to skip each iteration of h sort
    h_sort = 1
    while h_sort < length / 3:
        h_sort = 3 * h_sort + 1
    
    while h_sort >= 1:
        for i in range(h_sort, length):
            temp = arr[i]
            j = i
            while j >= h_sort and arr[j - h_sort] > temp:
                arr[j] = arr[j - h_sort]
                j -= h_sort
            arr[j] = temp
            
            
        h_sort //= 3 
    
if __name__ == "__main__":
    main()
        
    
