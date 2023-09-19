import random
import sys

if len(sys.argv) != 2:
    print("Usage: python numCreator.py <number>")
    sys.exit(1)


number_qty = int(sys.argv[1])
file_path = f"{number_qty}_int.txt"

numbers = (list(range(number_qty)))
random.shuffle(numbers)

with open(file_path, 'w') as file:
    # file.write(f"{number_qty} random integers\n\n")
    file.write("\n".join(map(str, numbers)))
        