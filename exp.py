import sys

if len(sys.argv) != 3:
    print("Usage: python exp.py <number> <exponent>")
    sys.exit(1)

number = int(sys.argv[1])
exponent = int(sys.argv[2])
def exponential(number, exp):
    if exp == 0:
        return 1
    elif exp == 1:
        return number
    else:
        return exponential(number, exp - 1) * number
print(exponential(number, exponent))