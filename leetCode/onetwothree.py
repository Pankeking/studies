'''
input = array of 0s, 1s, 2s, trash
eliminate trash
return array sorted
'''

def swap(arr, i, j):
    arr[i], arr[j] = arr[j], arr[i]
    
def sort(arr):    
    lo = 0
    mid = 0
    hi = len(arr) - 1
    trash = len(arr) - 1

    while mid <= hi:
        if arr[mid] == 0:
            swap(arr, lo, mid)
            lo += 1
            mid += 1
        elif arr[mid] == 1:
            mid += 1
        elif arr[mid] == 2:
            swap(arr, mid, hi)
            hi -= 1    
        else:
            swap(arr, mid, trash)
            if hi == trash:
                hi -= 1
            trash -= 1
    return arr[:trash + 1]


# Test Case 1: Sort an array with all 0s
array1 = [0, 0, 0, 0, 0]
print(sort(array1), end="-> array1\n\n")

# Test Case 2: Sort an array with all 1s
array2 = [1, 1, 1, 1, 1]
print(sort(array2), end="-> array2\n\n")

# Test Case 3: Sort an array with all 2s
array3 = [2, 2, 2, 2, 2]
print(sort(array3), end="-> array3\n\n")

# Test Case 4: Sort an array with a mix of 0s, 1s, and 2s
array4 = [1, 0, 2, 1, 0, 2]
print(sort(array4), end="-> array4\n\n")

# Test Case 5: Sort an empty array
array5 = []
print(sort(array5), end="-> array5\n\n")

# Test Case 6: Sort an array with only non-0,1,2 values
array6 = [3, 4, 5, 6, 7]
print(sort(array6), end="-> array6\n\n")

# Test Case 7: Sort an array with random values
array7 = [2, 1, 0, 3, 2, 1, 4, 0, 3]
print(sort(array7), end="-> array7\n\n")

# Test Case 8: Sort an array with a single element
array8 = [1]
print(sort(array8), end="-> array8\n\n")

# Test Case 9: Sort an array with a large number of elements
array9 = [0, 1, 2] * 1000
print(sort(array9), end="-> array9\n\n")

# Test Case 10: Sort an array with 0s, 1s, 2s, and other values
array10 = [0, 1, 2, 0, 1, 2, 3, 4, 5]
print(sort(array10), end="-> array10\n\n")
