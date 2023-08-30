# number = 2

# for _ in range(30, 0, -1):
#     print(number)
#     number = number * 2
    
def exponential(number, exp):
    if exp == 0:
        return 1
    elif exp == 1:
        return number
    else:
        return exponential(number, exp - 1) * number
print(exponential(9, 4))