import os
import sys

if len(sys.argv) != 3:
    print("Usage: scripter.py <amount> <shuffle || sorted>")
    sys.exit(1)
    
amount = int(sys.argv[1])
sorting = sys.argv[2]

input_data = f"{amount} < {sorting}_{amount}_int.txt"

command = f"python numCreator.py {amount} {sorting} && java-algs4 SelectionSort {input_data} && java-algs4 Insertion {input_data} && java-algs4 ShellSort {input_data}"
os.system(command)