import random

file_path = "3Sum.txt"

lower_bound = -100000
upper_bound = 100000
num_integers = 10000

randomNumbers = [random.randint(lower_bound, upper_bound) for _ in range(num_integers)]

with open(file_path, 'w') as file:
    file.write(f"{num_integers}\n\n")
    file.write("\n".join(map(str, randomNumbers)))