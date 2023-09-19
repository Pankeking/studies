import os
import sys

if len(sys.argv) != 3:
    print("Usage: scripter.py <amount> <shuffle || sorted>")
    sys.exit(1)
    
input_size = int(sys.argv[1])
init_state = sys.argv[2]

input_file = f"{init_state}_{input_size}_int.txt"

selection = f"&& java-algs4 SelectionSort {input_size} < {input_file}"
insertion = f"&& java-algs4 Insertion {input_size} < {input_file}"
shell = f"&& java-algs4 ShellSort {input_size} < {input_file}"
merge = f"&& java-algs4 MergeSort {input_size} < {input_file}"
b_up_merge = f"&& java-algs4 BottomUpMerge {input_size} < {input_file}"

python_merge = f"&& python merge_sort.py {input_file}"

command = f"python numCreator.py {input_size} {init_state} {shell} {merge} + {b_up_merge}"
os.system(command)