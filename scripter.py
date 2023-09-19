import os
import sys

if len(sys.argv) != 3:
    print("Usage: scripter.py <amount> <shuffle || sorted>")
    sys.exit(1)
    
input_size = int(sys.argv[1])
init_state = sys.argv[2]

input_data = f"{input_size} < {init_state}_{input_size}_int.txt"

selection = f"&& java-algs4 SelectionSort {input_data}"
insertion = f"&& java-algs4 Insertion {input_data}"
shell = f"&& java-algs4 ShellSort {input_data}"
merge = f"&& java-algs4 MergeSort {input_data}"

command = f"python numCreator.py {input_size} {init_state} {shell} {merge}"
os.system(command)