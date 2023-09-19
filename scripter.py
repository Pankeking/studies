import os
import sys

if len(sys.argv) != 2:
    print("Usage: scripter.py <amount>")
    sys.exit(1)
    
amount = int(sys.argv[1])
command = f"python numCreator.py {amount} && java-algs4 SelectionSort {amount} < {amount}_int.txt && java-algs4 Insertion {amount} < {amount}_int.txt"
os.system(command)