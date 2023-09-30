import os
import sys

if len(sys.argv) != 3:
    print("Usage: scripter.py <amount> <shuffled || sorted>")
    sys.exit(1)
    
input_size = int(sys.argv[1])
init_state = sys.argv[2]

input_file = f"{init_state}_{input_size}_int.txt"

selection = f"&& java-algs4 SelectionSort {input_size} < {input_file}"
insertion = f"&& java-algs4 Insertion {input_size} < {input_file}"
shell = f"&& java-algs4 ShellSort {input_size} < {input_file}"
merge = f"&& java-algs4 MergeSort {input_size} < {input_file}"
b_up_merge = f"&& java-algs4 BottomUpMerge {input_size} < {input_file}"
quick = f"&& java-algs4 Quick {input_size} < {input_file}"

python_shell = f"&& python shell_sort.py {input_file}"
python_merge = f"&& python merge_sort.py {input_file}"
python_quick = f"&& python leetCode/3waydijkstra.py {input_file}"

command = f"python numCreator.py {input_size} {init_state} {shell} {merge} {b_up_merge} {quick} {python_merge} {python_shell} {python_quick}"
os.system(command)
