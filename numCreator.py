import random
number_qty = 20
file_path = f"{number_qty}_int.txt"

numbers = (list(range(number_qty)))
random.shuffle(numbers)

with open(file_path, 'w') as file:
    # file.write(f"{number_qty} random integers\n\n")
    file.write("\n".join(map(str, numbers)))
        