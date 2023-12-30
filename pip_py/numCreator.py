import random
import sys


if len(sys.argv) != 3 or sys.argv[2] not in ["shuffled","sorted"]:
    print("Usage: python numCreator.py <number> <shuffled || sorted>")
    sys.exit(1)

method = sys.argv[2]
number_qty = int(sys.argv[1])

numbers = (list(range(number_qty)))
if method == "shuffled":
    random.shuffle(numbers)
file_path = f"{method}_{number_qty}_int.txt"
    

with open(file_path, 'w') as file:
    # file.write(f"{number_qty} random integers\n\n")
    file.write("\n".join(map(str, numbers)))
        