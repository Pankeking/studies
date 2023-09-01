import random
import math
    
arraySize = 200s
file_path = f"pitonic{arraySize}Array.txt"
peak_index = random.randint(0, arraySize - 1)
print("Peak Index: ", peak_index)
numbers_left = [math.floor(random.random() * peak_index) for _ in range (arraySize - peak_index)]
numbers_right = [math.floor(random.random() * (arraySize - peak_index)) for _ in range (peak_index)]
numbers_left.sort()
numbers_right.sort(reverse=True)
numbers = numbers_left + numbers_right
    
with open(file_path, "w") as file:
    file.write(f"{arraySize}\n\n")
    file.write("\n".join(map(str, numbers)))
    
    
    