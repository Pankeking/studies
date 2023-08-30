import random

file_path = "3Sum.txt"

lower_bound = 0
upper_bound = 1000
num_integers = 200

randomNumbers = [random.randint(lower_bound, upper_bound) for _ in range(num_integers)]

with open(file_path, 'w') as file:
    file.write(",\n".join(map(str, randomNumbers)))