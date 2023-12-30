import random
maxValue = 2500000

peak_left = random.randint(0, maxValue)
start_left = random.randint(0, peak_left)
numbers_left = sorted(range(start_left, peak_left))

peak_right = random.randint(0, maxValue)
start_right = random.randint(0, peak_right)
numbers_right = (list(range(start_right, peak_right)))

print(f"{peak_left} / {peak_right}")

numbers_right.sort(reverse=True)
numbers = numbers_left + numbers_right

sampleSize = len(numbers)
file_path = "bitonicArray.txt"
    
with open(file_path, "w") as file:
    file.write(f"{sampleSize}\n\n")
    file.write("\n".join(map(str, numbers)))
    