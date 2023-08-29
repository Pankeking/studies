import random
file_path = "8k_int.txt"
data = ""

numbers = (list(range(1, 80001)))
random.shuffle(numbers)

with open(file_path, 'w') as file:
    file.write("8000 random integers\n\n")
    file.write(",\n".join(map(str, numbers)))
        