import os
import sys

if len(sys.argv) != 3:
    print("Usage: scripter.py <amount> <shuffle-method>")
    sys.exit(1)
    
amount = int(sys.argv[1])
method = sys.argv[2]
command = f"python numCreator.py {amount} {method} && java-algs4 SelectionSort {amount} < {method}_{amount}_int.txt && java-algs4 Insertion {amount} < {method}_{amount}_int.txt"
os.system(command)