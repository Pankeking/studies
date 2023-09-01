import random
file_path = "80k_int.txt"
number_qty = 80000

numbers = (list(range(1, number_qty)))
random.shuffle(numbers)

with open(file_path, 'w') as file:
    file.write(f"{number_qty} random integers\n\n")
    file.write("\n".join(map(str, numbers)))
        